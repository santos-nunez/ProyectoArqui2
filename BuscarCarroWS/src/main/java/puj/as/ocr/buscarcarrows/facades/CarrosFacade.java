/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puj.as.ocr.buscarcarrows.facades;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import puj.as.ocr.sidecarocr.entities.Carro;

/**
 *
 * @author admin
 */
@Stateless
public class CarrosFacade extends AbstractFacade<Carro> {

    @PersistenceContext(unitName = "my_persistence_unit")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CarrosFacade() {
        super(Carro.class);
    }

    public List<Carro> findByLocation(String localizacion) {
        TypedQuery<Carro> query
                = em.createQuery(
                        "select c from Carro c where c.localizacion=:local",
                         Carro.class
                );
        query.setParameter("local", localizacion);
        return query.getResultList();
    }

}
