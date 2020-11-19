/*
 * Classe para realizar comandos DML 
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gustavo.model;

import br.com.gustavo.model.Pessoa;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Gustavo
 */
public class PessoaDAO {
    
    public void cadastropessoa(Pessoa pessoa) throws ExceptionDAO, ClassNotFoundException {
        String sql = "insert into pessoa (cod, nome, idade) values (?, ?, ?) ";
        PreparedStatement pStatement = null;
        Connection connection = null;
        
        try {
            connection = new ConnectionJDBC().getConnection();
            pStatement = connection.prepareStatement(sql);
            pStatement.setString(1, pessoa.getCod());
            pStatement.setString(2, pessoa.getNome());
            pStatement.setString(3, pessoa.getIdade());          
                        
        }catch (SQLException e){
            throw new ExceptionDAO("Erro ao cadastrar cliente. /n Erro: " + e);
        } finally {
            
            try {
                if (pStatement != null)
                {
                    pStatement.close();
                }
            } 
            catch (SQLException e){
                throw new ExceptionDAO("Erro ao fechar o Statement. /n Erro: " + e);
            }
            try {
                if (connection != null)
                {   
                    connection.close();
                }
            }
            catch (SQLException  e){
                throw new ExceptionDAO("Erro ao conectar o Statement. /n Erro: " + e);
            }
        }
    
    
    }


}