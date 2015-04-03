/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.wscompany.servicos;

import br.com.wscompany.daos.CervejaDao;
import br.com.wscompany.modelos.Cerveja;
import br.com.wscompany.utilitarias.Problema;
import com.google.gson.Gson;
import java.sql.SQLException;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Wagner
 */
@Path("cervejas")
public class CervejaService {

    private final CervejaDao c_dao;

    public CervejaService() {

        c_dao = new CervejaDao();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response criarCerveja(String str_cerveja) {
        try {

            Cerveja cerveja_nova = new Gson().fromJson(str_cerveja, Cerveja.class);

            c_dao.criarCerveja(cerveja_nova);

            return Response.status(201).build();

        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCervejas() {

        try {

            String json_cervejas = new Gson().toJson(c_dao.listarCervejas());

            return Response.status(Response.Status.OK).entity(json_cervejas).build();

        } catch (SQLException se) {

            String error_json = new Gson().toJson(new Problema(se.getMessage()));
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(error_json).build();
        } catch (Exception e) {

            String error_json = new Gson().toJson(new Problema(e.getMessage()));
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(error_json).build();
        }

    }

    @GET()
    @Path("{codigo}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCervejaPorCodigo(@PathParam("codigo") int codigo_cerveja) {

        try {

            Cerveja cerveja = c_dao.buscaCervejaPorCodgio(codigo_cerveja);

            String json_cerveja = new Gson().toJson(cerveja);

            return Response.status(Response.Status.OK).entity(json_cerveja).build();

        }  catch (Exception e) {

            String error_json = new Gson().toJson(new Problema(e.getMessage()));
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(error_json).build();
        }

    }

    @GET()
    @Path("/ano")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCervejasPorAno(@QueryParam("valor") int valor, @QueryParam("menor") boolean isMenor, @QueryParam("maior") boolean isMaior) {

        try {
            String json_cerveja = "";

            if (isMenor == false && isMaior == false) {

                json_cerveja = new Gson().toJson(c_dao.listarCervejasPorAno(valor, CervejaDao.comparador_ano.IGUAL_QUE));
            }

            if (isMenor) {

                json_cerveja = new Gson().toJson(c_dao.listarCervejasPorAno(valor, CervejaDao.comparador_ano.MENOR_QUE));
            }

            if (isMaior) {
                json_cerveja = new Gson().toJson(c_dao.listarCervejasPorAno(valor, CervejaDao.comparador_ano.MAIOR_QUE));
            }

            return Response.status(Response.Status.OK).entity(json_cerveja).build();

        } catch (SQLException se) {

            String error_json = new Gson().toJson(new Problema(se.getMessage()));
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(error_json).build();
        } catch (Exception e) {

            String error_json = new Gson().toJson(new Problema(e.getMessage()));
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(error_json).build();
        }
    }
}
