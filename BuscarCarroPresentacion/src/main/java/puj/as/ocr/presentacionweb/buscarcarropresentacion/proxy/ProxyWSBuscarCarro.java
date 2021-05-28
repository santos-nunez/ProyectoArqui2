/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puj.as.ocr.presentacionweb.buscarcarropresentacion.proxy;

import java.util.List;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import puj.as.ocr.sidecarocr.entities.Carro;

/**
 * Jersey REST client generated for REST resource:WSManagerCarro
 * [ManagerCarro]<br>
 * USAGE:
 * <pre>
 *        ProxyWSBuscarCarro client = new ProxyWSBuscarCarro();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author admin
 */
public class ProxyWSBuscarCarro {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/BuscarCarroWS/resources";

    public ProxyWSBuscarCarro() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("ManagerCarro");
    }

    public <T> List<Carro> buscarCarrosByLocalizacion(String loc) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("search/{0}", new Object[]{loc}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(new GenericType<List<Carro>>() {
        });
    }

    public void close() {
        client.close();
    }
    
}
