/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.wscompany.daos;

import br.com.wscompany.modelos.Cerveja;
import br.com.wscompany.daos.PreparaResultSet;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Wagner
 */
public class CervejaDao {

    private static List<Cerveja> cervejas;
    private PreparaResultSet prepara_rs;
    private String sql;

    public CervejaDao() {
        sql = "";
        if (cervejas == null) {
            cervejas = new LinkedList<Cerveja>();
        }
    }

    public List<Cerveja> listarCervejas() throws ClassNotFoundException, SQLException {

        sql = "SELECT cod, nome, ano FROM cervejaria.cervejas";

        SingletonConexao.getInstance().conectar();

        preencheCervejas(sql);

        SingletonConexao.getInstance().desconecatar();

        return this.cervejas;
    }

    private void preencheCervejas(String sql) throws SQLException {

        cervejas = new LinkedList<>();
        
        ResultSet rs = prepara_rs.obterResultSet(sql);

        while (rs.next()) {

            Cerveja nova_cerveja = new Cerveja(rs.getInt("cod"), rs.getString("nome"), rs.getInt("ano"));

            cervejas.add(nova_cerveja);
        }
        rs.close();
    }

    public void criarCerveja(Cerveja cerveja_nova) {

        cervejas.add(cerveja_nova);
    }

    public Cerveja buscaCervejaPorCodgio(int codigo) {

        for (Cerveja cerveja : cervejas) {

            if (cerveja.getCodigo() == codigo) {

                return cerveja;
            }
        }

        return null;
    }

}
