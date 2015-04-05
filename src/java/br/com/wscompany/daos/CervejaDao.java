/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.wscompany.daos;

import br.com.wscompany.modelos.Cerveja;
import br.com.wscompany.utilitarias.PreparaResultSet;
import br.com.wscompany.utilitarias.RetornaCervejas;
import java.sql.PreparedStatement;
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

    public void criarCerveja(Cerveja cerveja_nova) throws ClassNotFoundException, SQLException {

        sql = "INSERT INTO cervejaria.cervejas (nome, ano, importada) VALUES (?,?,?);";

        SingletonConexao.getInstance().conectar();

        PreparedStatement prepared_statement = SingletonConexao.getInstance().getConexao().prepareStatement(sql);

        prepared_statement.setString(1, cerveja_nova.getNome());

        prepared_statement.setInt(2, cerveja_nova.getAno());
        
         prepared_statement.setBoolean(3, cerveja_nova.getImportada());

        prepared_statement.execute();

        SingletonConexao.getInstance().desconecatar();

    }

    public void alterarCerveja(Cerveja cerveja_update) throws ClassNotFoundException, SQLException {

        sql = "UPDATE cervejaria.cervejas SET nome = ?,  ano = ? WHERE cod = ?";

        SingletonConexao.getInstance().conectar();

        PreparedStatement prepared_statement = SingletonConexao.getInstance().getConexao().prepareStatement(sql);

        prepared_statement.setString(1, cerveja_update.getNome());

        prepared_statement.setInt(2, cerveja_update.getAno());

        prepared_statement.setInt(3, cerveja_update.getCodigo());

        prepared_statement.execute();

        SingletonConexao.getInstance().desconecatar();

    }

    public void deletarCerveja(int id_cerveja) throws ClassNotFoundException, SQLException {

        sql = "DELETE FROM cervejaria.cervejas where cod = ?";

        SingletonConexao.getInstance().conectar();

        PreparedStatement prepared_statement = SingletonConexao.getInstance().getConexao().prepareStatement(sql);

        prepared_statement.setInt(1, id_cerveja);

        prepared_statement.execute();

        SingletonConexao.getInstance().desconecatar();

    }

    public Cerveja buscaCervejaPorCodgio(int codigo) throws ClassNotFoundException, SQLException {

        sql = "SELECT cod, nome, ano, importada FROM cervejaria.cervejas WHERE cod = " + codigo;

        return RetornaCervejas.getCervejaPorCodigo(sql);
    }

    public List<Cerveja> listarCervejas() throws ClassNotFoundException, SQLException {

        sql = "SELECT cod, nome, ano, importada FROM cervejaria.cervejas";

        return RetornaCervejas.getCervejas(sql);
    }

    public List<Cerveja> listarCervejasPorImportacao(boolean isImportada) throws ClassNotFoundException, SQLException {

        sql = "SELECT cod, nome, ano, importada FROM cervejaria.cervejas WHERE importada = " + isImportada;

        return RetornaCervejas.getCervejas(sql);
    }

    public List<Cerveja> listarCervejasPorAno(int ano, comparador_ano comparador_selecionado) throws ClassNotFoundException, SQLException {

        sql = "SELECT cod, nome, ano, importada FROM cervejaria.cervejas WHERE ano ";

        if (comparador_selecionado == comparador_ano.MENOR_QUE) {

            sql += "<" + ano;
        }

        if (comparador_selecionado == comparador_ano.MAIOR_QUE) {

            sql += ">" + ano;
        }

        if (comparador_selecionado == comparador_ano.IGUAL_QUE) {

            sql += "=" + ano;
        }

        return RetornaCervejas.getCervejas(sql);
    }

}
