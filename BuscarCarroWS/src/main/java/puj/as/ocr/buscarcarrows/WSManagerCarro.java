/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puj.as.ocr.buscarcarrows;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import puj.as.ocr.buscarcarrows.facades.CarrosFacade;
import puj.as.ocr.sidecarocr.entities.Carro;

/**
 * REST Web Service
 *
 * @author admin
 */
@Path("ManagerCarro")
@RequestScoped
public class WSManagerCarro {

    @Context
    private UriInfo context;

    @Inject
    CarrosFacade facade;

    /**
     * Creates a new instance of WSManagerCarro
     */
    public WSManagerCarro() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/search/{loc}")
    public Response buscarCarrosByLocalizacion(@PathParam("loc") String localizacion) {
        List<Carro> carros = facade.findByLocation(localizacion);        
        if (carros.size() > 0) {
            return Response
                    .ok(carros)
                    .build();
        }
        return Response
                .status(Response.Status.NO_CONTENT)
                .build();
    }

}
