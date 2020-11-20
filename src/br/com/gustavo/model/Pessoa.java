/*
 * Classe criada para podermos realizar a transição dos dados inseridos ou lidos para o banco ou para a saída para o usuário
 * 
 */
package br.com.gustavo.model;

/**
 * @brief classe genérica para controle e transferencia de dados
 * @author Daniel Fontoura <fontoura.daniel at hotmail.com>
 * @author Gustavo Almeida Wong <gustavoalmeidawong at hotmail.com>
 * @author Roberto Ferreira Torres <roberto.ftorres at hotmail.com>
 * @author Afonso Vika Lopes <afonsovika at hotmail.com>
 * @date 06/10/2020
 */
import br.com.gustavo.model.PessoaDAO;

public class Pessoa {
    public String cod;
    public String idade;
    public String nome;
    public String cpf;
    public String sexo;
    public String profissao;

    Pessoa(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Pessoa() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    

    
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
    public String getCpf() {
        return cpf;
    }
    public String getSexo() {
        return sexo;
    }
    public String getProfissao() {
        return profissao;
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
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }
    public void cadastropessoa(Pessoa pessoa) throws ExceptionDAO, ClassNotFoundException{
        new PessoaDAO().cadastropessoa(pessoa);
        
    }
    
}
