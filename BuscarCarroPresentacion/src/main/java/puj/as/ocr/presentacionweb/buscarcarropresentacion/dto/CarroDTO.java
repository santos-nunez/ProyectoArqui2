/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puj.as.ocr.presentacionweb.buscarcarropresentacion.dto;

import javax.ws.rs.FormParam;
import puj.as.ocr.sidecarocr.entities.Carro;

/**
 *
 * @author admin
 */
public class CarroDTO extends Carro{
    
    @Override
    @FormParam("localizacion")
    public void setLocalizacion(String localizacion) {
        super.setLocalizacion(localizacion); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @FormParam("localizacion")
    public String getLocalizacion() {
        return super.getLocalizacion(); //To change body of generated methods, choose Tools | Templates.
    }
}
