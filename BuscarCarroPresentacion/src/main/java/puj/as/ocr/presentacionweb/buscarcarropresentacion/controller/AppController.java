package puj.as.ocr.presentacionweb.buscarcarropresentacion.controller;

import java.util.List;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.View;
import javax.mvc.security.CsrfProtected;
import javax.validation.Valid;
import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import puj.as.ocr.presentacionweb.buscarcarropresentacion.dto.CarroDTO;
import puj.as.ocr.presentacionweb.buscarcarropresentacion.proxy.ProxyWSBuscarCarro;
import puj.as.ocr.presentacionweb.buscarcarropresentacion.repositorios.OCRCarrosRepositorio;
import puj.as.ocr.sidecarocr.entities.Carro;

@Path("app")
@Controller
public class AppController {

    @Inject
    OCRCarrosRepositorio repositorio;
        
    
    @GET
    @Path("/buscarCarros")
    @View("buscarCarroPantalla.xhtml")
    public void buscarPorLocalizacion() {
        Carro carro = new Carro();
        repositorio.setCarroLocalizacion(carro);
    }
    
    @POST
    @Path("/buscarCarros/resultados")
    @View("ResultadosBuscarCarroPantalla.xhtml")
    @Consumes({MediaType.APPLICATION_FORM_URLENCODED})
    public void mostrarResultados(@Valid @BeanParam CarroDTO carro) {
        ProxyWSBuscarCarro proxy = new ProxyWSBuscarCarro();
        List<Carro> carros = proxy.buscarCarrosByLocalizacion(carro.getLocalizacion());
        repositorio.setCarros(carros);
    }
}
