/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.wscompany.servicos;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author Wagner
 */
public class ApplicationJAXRS extends Application {

    @Override
    public Map<String, Object> getProperties() {//Esse metodo premite que se adicione todos os serviços de um determinado 'Pacote'

        Map<String, Object> properties = new HashMap<>();

        properties.put("jersey.config.server.provider.packages", "br.com.wscompany.servicos");

        return properties;

    }

}//Fim Classe configuração
