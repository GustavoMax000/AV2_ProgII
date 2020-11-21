/**
 * @brief classe genérica para controle e transferencia de dados
 * @author Daniel Fontoura <fontoura.daniel at hotmail.com>
 * @author Gustavo Almeida Wong <gustavoalmeidawong at hotmail.com>
 * @author Roberto Ferreira Torres <roberto.ftorres at hotmail.com>
 * @author Afonso Vika Lopes <afonsovika at hotmail.com>
 * @date 06/10/2020
 */
package br.com.unesa.model;

import br.com.unesa.model.Pessoa;
import br.com.unesa.model.ConnectionJDBC;
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
        String sql = "insert into pessoa (cod, nome, idade, CPF, SEXO, PROFISSAO) values (?, ?, ?, ?, ?, ?) ";
        PreparedStatement pStatement = null;
        Connection connection = null;
        
        try {
            connection = new ConnectionJDBC().getConnection();
            pStatement = connection.prepareStatement(sql);
            pStatement.setString(1, pessoa.getCod());
            pStatement.setString(2, pessoa.getNome());
            pStatement.setString(3, pessoa.getIdade());
            pStatement.setString(3, pessoa.getCpf());
            pStatement.setString(3, pessoa.getSexo());
            pStatement.setString(3, pessoa.getProfissao());
                        
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
         
    public String buscarPessoa(String cod) throws SQLException{
        Connection connection = null;
        Statement pStatement = null;
        String result = "";
        try{
            connection = new ConnectionJDBC().getConnection();
            pStatement = connection.createStatement();
            ResultSet rs = pStatement.executeQuery(String.format("SELECT NOME FROM PESSOA WHERE COD = ?", cod));
            result = rs.getString(1);
            
        }
        catch(Exception e){
            
        }finally{
           connection.close();
        }
        return result;
    }
    
    public void alteraPessoa (Pessoa pessoa) throws SQLException{
        Connection connection = null;
        try{
            connection =  new ConnectionJDBC().getConnection();
            PreparedStatement st = connection.prepareStatement("update cliente set NOME = ?, IDADE = ?, CPF = ?, SEXO = ?, PROFISSAO = ?, where COD = ?");
            st.setString(1, pessoa.nome);
            st.setString(2, pessoa.idade);
            st.setString(3, pessoa.cpf);
            st.setString(4, pessoa.sexo);
            st.setString(5, pessoa.profissao);
            st.setString(6, pessoa.cod);
            st.executeUpdate();
            
        }catch (Exception e){
            
        }finally{
            connection.close();
        }
    }
    public List<Pessoa> listar() throws SQLException{
        ArrayList<Pessoa> pessoas = new ArrayList();
        Connection connection = null;
        try{
            connection = new ConnectionJDBC().getConnection();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("Select NOME from Pessoa");
            
            while (rs.next()){
                pessoas.add(new Pessoa(rs.getString(1)));
            }
        }catch (Exception e){
        
        }finally{
            connection.close();
        } 
        return pessoas;
    }

}