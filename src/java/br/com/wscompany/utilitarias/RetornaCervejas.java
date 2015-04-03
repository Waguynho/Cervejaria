/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.wscompany.utilitarias;

import br.com.wscompany.daos.SingletonConexao;
import br.com.wscompany.modelos.Cerveja;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Wagner
 */
public class RetornaCervejas {

    public static List<Cerveja> getCervejas(String sql) throws ClassNotFoundException, SQLException {

        List<Cerveja> cervejas;

        SingletonConexao.getInstance().conectar();

        cervejas = PreencheCerveja.retornaCervejasPreenchidas(sql);

        SingletonConexao.getInstance().desconecatar();

        return cervejas;
    }

    public static Cerveja getCervejaPorCodigo(String sql) throws ClassNotFoundException, SQLException {

        Cerveja cerveja;

        SingletonConexao.getInstance().conectar();

        cerveja = PreencheCerveja.retornaCervejaPreenchida(sql);

        SingletonConexao.getInstance().desconecatar();

        return cerveja;
    }
}
