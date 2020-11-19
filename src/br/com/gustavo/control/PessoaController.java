/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gustavo.control;
import br.com.gustavo.model.ExceptionDAO;
import br.com.gustavo.model.Pessoa;
/**
 *
 * @author Gustavo
 */
public class PessoaController {
    
    public boolean CadastroPessoa(String cod, String idade, String nome) throws ExceptionDAO, ClassNotFoundException{
        if (cod != null && cod.length() > 0 && idade != null && idade.length() > 0 && nome != null && nome.length() > 0){
             //Pessoa pessoa = new Pessoa(cod, idade, nome);
             Pessoa pessoa = new Pessoa();
             pessoa.cadastropessoa(pessoa);
             return true; 
        }
        return false;
        
    }
}
