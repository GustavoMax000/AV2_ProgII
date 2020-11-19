/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gustavo.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Gustavo
 */
public class ConnectionJDBC {
    
    static String driverJDBC = "org.apache.derby.jdbc.ClientDriver";
    static String url = "jdbc:derby://localhost:1527/banco_users";
    static String user = "ad";
    static String pass = "ad";
    
    
    public Connection getConnection() throws ClassNotFoundException, SQLException{
        Connection conn = null;
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        
        } catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Erro: "+ ex);
        }
        try{
            
        conn = DriverManager.getConnection(url,user,pass);
        } catch (Exception e){
            JOptionPane.showMessageDialog(null,"Erro: " + e);
        }
        return conn;
    }
}
