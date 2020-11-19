/*
 * Classe criada para podermos realizar a transição dos dados inseridos ou lidos para o banco ou para a saída para o usuário
 * 
 */
package br.com.gustavo.model;

/**
 *
 * @author Gustavo
 */
import br.com.gustavo.model.PessoaDAO;

public class Pessoa {
    public String cod;
    public String idade;
    public String nome;

    
//----------- setter e getters -----------
    
    //getters
    
    public String getCod() {
        return cod;
    }

    public String getIdade() {
        return idade;
    }
    public String getNome() {
        return nome;
    }

    //setters

    public void setCod(String cod) {
        this.cod = cod;
    }
    public void setIdade(String idade) {
        this.idade = idade;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void cadastropessoa(Pessoa pessoa) throws ExceptionDAO, ClassNotFoundException{
        new PessoaDAO().cadastropessoa(pessoa);
        
    }
    
}
