/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author 05200245
 */
public class Pessoa {
    protected String nome;
    protected String senha;
    protected String telefone;
    protected String email;
    protected String tipo;
    protected String endereco;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "nome=" + nome + ", senha=" + senha + ", telefone=" + telefone + ", email=" + email + '}';
    }

    public Pessoa(String nome, String senha, String telefone, String email,String endereco,String tipo) {
        this.nome = nome;
        this.senha = senha;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
        this.tipo = tipo;
    }
  
    
}
