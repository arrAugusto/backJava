/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.enterprise.context.RequestScoped;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import models.GuardarServiciosSOAP;
import wsBancoGuatemala.InfoVariable;
import wsBancoGuatemala.VarDolar;
import wsBancoGuatemala.Variable;

/**
 * REST Web Service
 *
 * @author agr12
 */
@Path("generic")
@RequestScoped
public class GenericResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public GenericResource() {
    }

    /**
     * Retrieves representation of an instance of com.mycompany.mavenproject1.GenericResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJson() {
        
        GuardarServiciosSOAP guardarServiciosSOAP = new GuardarServiciosSOAP();
        List<String> miLista = new ArrayList<String>();
        VarDolar variableArray = guardarServiciosSOAP.guardarTipoCambioDia();
        //ResponseJSON  response = new ResponseJSON(variableArray.getFecha(), variableArray.getReferencia());

        
        
        JsonObjectBuilder jsonObjectBuilder = Json.createObjectBuilder();
        jsonObjectBuilder.add("datosResponse", "");
        JsonObject jsonObj = jsonObjectBuilder.build();
        return Response.ok(jsonObj.toString())
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Credentials", "true")
                .header("Access-Control-Allow-Methods", "GET, POST, ssDELETE, PUT, OPTIONS, HEAD")
                .header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With").build();
        
    }

    /**
     * PUT method for updating or creating an instance of GenericResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
