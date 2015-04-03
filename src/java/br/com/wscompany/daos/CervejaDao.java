/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.wscompany.daos;


import br.com.wscompany.modelos.Cerveja;
import br.com.wscompany.utilitarias.PreparaResultSet;
import br.com.wscompany.utilitarias.RetornaCervejas;
import java.util.LinkedList;
import java.util.List;
import java.sql.SQLException;

/**
 *
 * @author Wagner
 */
public class CervejaDao {

    private static List<Cerveja> cervejas;
    private PreparaResultSet prepara_rs;
    private String sql;

    public enum comparador_ano {

        IGUAL_QUE, MENOR_QUE, MAIOR_QUE
    };

    public CervejaDao() {
        sql = "";
        if (cervejas == null) {
            cervejas = new LinkedList<Cerveja>();
        }
    }

    public List<Cerveja> listarCervejas() throws ClassNotFoundException, SQLException {

        sql = "SELECT cod, nome, ano FROM cervejaria.cervejas";

        return RetornaCervejas.getCervejas(sql);
    }

    public List<Cerveja> listarCervejasPorAno(int ano, comparador_ano comparador_selecionado) throws ClassNotFoundException, SQLException {

        if (comparador_selecionado == comparador_ano.MENOR_QUE) {

            sql = "SELECT cod, nome, ano FROM cervejaria.cervejas WHERE ano < " + ano;
        }

        if (comparador_selecionado == comparador_ano.MAIOR_QUE) {

            sql = "SELECT cod, nome, ano FROM cervejaria.cervejas WHERE ano > " + ano;
        }

        if (comparador_selecionado == comparador_ano.IGUAL_QUE) {

            sql = "SELECT cod, nome, ano FROM cervejaria.cervejas WHERE ano = " + ano;
        }

        return RetornaCervejas.getCervejas(sql);
    }

    public void criarCerveja(Cerveja cerveja_nova) {

        cervejas.add(cerveja_nova);
    }

    public Cerveja buscaCervejaPorCodgio(int codigo) throws ClassNotFoundException, SQLException {

        sql = "SELECT cod, nome, ano FROM cervejaria.cervejas WHERE cod = " + codigo;

        return RetornaCervejas.getCervejaPorCodigo(sql);
    }

}
