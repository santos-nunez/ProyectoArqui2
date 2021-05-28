/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puj.as.ocr.buscarcarrows.facades;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import puj.as.ocr.sidecarocr.entities.Propietario;

/**
 *
 * @author admin
 */
@Stateless
public class PropietariosFacade extends AbstractFacade<Propietario> {

    @PersistenceContext(unitName = "my_persistence_unit")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PropietariosFacade() {
        super(Propietario.class);
    }
    
}
