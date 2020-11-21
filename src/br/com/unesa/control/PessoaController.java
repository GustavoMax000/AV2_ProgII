/**
 * @brief classe genérica para controle e transferencia de dados
 * @author Daniel Fontoura <fontoura.daniel at hotmail.com>
 * @author Gustavo Almeida Wong <gustavoalmeidawong at hotmail.com>
 * @author Roberto Ferreira Torres <roberto.ftorres at hotmail.com>
 * @author Afonso Vika Lopes <afonsovika at hotmail.com>
 * @date 06/10/2020
 */
package br.com.unesa.control;
import br.com.unesa.model.ExceptionDAO;
import br.com.unesa.model.Pessoa;
import br.com.unesa.model.PessoaDAO;
import java.sql.SQLException;
import java.util.List;
/**
 *
 * @author Gustavo
 */
public class PessoaController {
    PessoaDAO pessoadao = new PessoaDAO();
    
    public boolean CadastroPessoa(String cod, String idade, String nome, String cpf, String sexo, String profissao) throws ExceptionDAO, ClassNotFoundException{
        if (cod != null && cod.length() > 0 && idade != null && idade.length() > 0 && nome != null && nome.length() > 0 && cpf != null && cpf.length() > 0 && sexo != null && sexo.length() > 0 && profissao != null && profissao.length() > 0){
             //Pessoa pessoa = new Pessoa(cod, idade, nome);
             Pessoa pessoa = new Pessoa();
             pessoa.cadastropessoa(pessoa);
             return true; 
        }
        
        return false;
        
    }
    public String PesquisaPessoa(String cod) throws SQLException{
        return pessoadao.buscarPessoa(cod);
    } 
    
    public void AlteraPessoa(Pessoa pessoa) throws SQLException{
        pessoadao.alteraPessoa(pessoa);
        
    }
    public List<Pessoa> ListarPessoas() throws SQLException{
        return pessoadao.listar();
    }
}
