/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.wscompany.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author Wagner
 */
public class SingletonConexao {

    private static SingletonConexao singleton_con;
    private static Connection conexao;

    private SingletonConexao() throws ClassNotFoundException, SQLException {

    }

    public static SingletonConexao getInstance() throws ClassNotFoundException, SQLException {
        if (singleton_con == null) {

            return singleton_con = new SingletonConexao();
        }
        return singleton_con;
    }
    
    public Connection getConexao(){
   
        return conexao;
           
    }

    public void conectar() throws ClassNotFoundException, SQLException {
        
            Class.forName("com.mysql.jdbc.Driver");
            conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/cervejaria",
                    "wagner",
                    "789789");
    }
    
    public void desconecatar() throws  SQLException {
        
            conexao.close();
        
    }

}
