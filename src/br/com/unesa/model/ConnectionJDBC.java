/**
 * @brief classe genérica para controle e transferencia de dados
 * @author Daniel Fontoura <fontoura.daniel at hotmail.com>
 * @author Gustavo Almeida Wong <gustavoalmeidawong at hotmail.com>
 * @author Roberto Ferreira Torres <roberto.ftorres at hotmail.com>
 * @author Afonso Vika Lopes <afonsovika at hotmail.com>
 * @date 06/10/2020
 */
package br.com.unesa.model;

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
        //try{
        //    
        //conn = DriverManager.getConnection(url,user,pass);
        //} catch (Exception e){
        //    JOptionPane.showMessageDialog(null,"Erro: " + e);
        //}
        return DriverManager.getConnection(url,user,pass);
    }
}
