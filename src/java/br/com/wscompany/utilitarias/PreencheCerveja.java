/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.wscompany.utilitarias;


import br.com.wscompany.modelos.Cerveja;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Wagner
 */
public class PreencheCerveja {

    private static List<Cerveja> cervejas;
    private static PreparaResultSet prepara_rs;

    public static List<Cerveja> retornaCervejasPreenchidas(String sql) throws ClassNotFoundException, SQLException {

        cervejas = new LinkedList<>();

        ResultSet rs = prepara_rs.obterResultSet(sql);

        while (rs.next()) {

            Cerveja nova_cerveja = new Cerveja(rs.getInt("cod"), rs.getString("nome"), rs.getInt("ano"));

            cervejas.add(nova_cerveja);
        }
        rs.close();

        return cervejas;
    }
    
     public static Cerveja retornaCervejaPreenchida(String sql) throws ClassNotFoundException, SQLException {

        Cerveja cerveja;

        ResultSet rs = prepara_rs.obterResultSet(sql);

        while (rs.next()) {

            Cerveja nova_cerveja = new Cerveja(rs.getInt("cod"), rs.getString("nome"), rs.getInt("ano"));

            return nova_cerveja;
        }
        rs.close();

        return new Cerveja(0, "Não Achou", 0000);
    }
}
