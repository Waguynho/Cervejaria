/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.wscompany.servicos;

import br.com.wscompany.modelos.Cerveja;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


/**
 *
 * @author Wagner
 */
@Path("cervejas")
public class CervejaService {
    
    private List<Cerveja> cervejas;
    
    public CervejaService(){
    iniciaEstoqueCervejas();
    }
    
    @GET 
    @Produces(MediaType.APPLICATION_JSON) 
    public Response getCervejas() {
    
        try {           
            
            
            String json_cervejas = new Gson().toJson(cervejas);
            
            return Response.status(Response.Status.OK).entity(json_cervejas).build();
            
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
        
    }
    
    @GET() 
    @Path("/{id_ano}")
    @Produces(MediaType.APPLICATION_JSON) 
    public Response getCerveja(@PathParam("/{id_ano}") int id_ano) {
    
        try {           
            iniciaEstoqueCervejas();
            String json_cerveja = "";
            
            for (Cerveja cerveja : cervejas) {
                
                if (cerveja.getAno() == id_ano) {
                    json_cerveja = new Gson().toJson(cerveja);
                    break;
                }
            }
            
            return Response.status(Response.Status.OK).entity(json_cerveja).build();
            
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
        
    }
    
    private void iniciaEstoqueCervejas(){
    
        cervejas = new ArrayList<Cerveja>();
        
        cervejas.add(new Cerveja(2004, "Heinkg", true));
        cervejas.add(new Cerveja(1968, "Stella", false));
        cervejas.add(new Cerveja(1997, "Humbrela", true));
    
    }
    
}


