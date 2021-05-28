/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puj.as.ocr.presentacionweb.buscarcarropresentacion.repositorios;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import puj.as.ocr.sidecarocr.entities.Carro;

/**
 *
 * @author admin
 */
@Named(value = "OCRCarrosRepositorio")
@SessionScoped
public class OCRCarrosRepositorio implements Serializable {

    /**
     * Creates a new instance of OCRCarrosRepositorio
     */
    
    private List<Carro> carros;
    
    private Carro carroLocalizacion;
    
    public OCRCarrosRepositorio() {
    }

    public List<Carro> getCarros() {
        return carros;
    }

    public void setCarros(List<Carro> carros) {
        this.carros = carros;
    }

    public Carro getCarroLocalizacion() {
        return carroLocalizacion;
    }

    public void setCarroLocalizacion(Carro carroLocalizacion) {
        this.carroLocalizacion = carroLocalizacion;
    }


    
    
}
