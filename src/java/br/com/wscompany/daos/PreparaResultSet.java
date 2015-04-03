/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.wscompany.daos;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Wagner
 */
public class PreparaResultSet {

 
    public static ResultSet obterResultSet(String sql) throws SQLException {
        //Obtem statement, que permite criar consulta simples
        ResultSet rs = null;
        
        try {

            Statement statement = null;

            statement = SingletonConexao.getInstance().getConexao().createStatement();

            //Obtem resultado de uma consulta
            rs = statement.executeQuery(sql);
            
            

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PreparaResultSet.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("WAGNER, O ERRO É: " + ex.getMessage());
          
        }

        return rs;
    }
    
    
     public static void executaResultSetNonQuery(ResultSet result_set, String sql) throws SQLException {
         /*     
        
        try {

            Statement statement = null;

            statement = SingletonConexao.getInstance().getConexao().createStatement();

            //Obtem resultado de uma consulta
            result_set = statement.executeQuery(sql);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PreparaResultSet.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("WAGNER, O ERRO É: " + ex.getMessage());
        }

        */
    }
}
