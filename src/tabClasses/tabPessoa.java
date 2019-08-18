/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabClasses;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author erick
 */
public class tabPessoa {

    private final StringProperty idCliente;
    private final StringProperty nome;
    private final StringProperty cpf;
    private final StringProperty telefone;
    private final StringProperty email;
    private final StringProperty endereco;

    public tabPessoa(String idCliente, String nome, String cpf, String telefone, String email, String endereco) {
        this.idCliente = new SimpleStringProperty(idCliente);
        this.nome = new SimpleStringProperty(nome);
        this.cpf = new SimpleStringProperty(cpf);
        this.telefone = new SimpleStringProperty(telefone);
        this.email = new SimpleStringProperty(email);
        this.endereco = new SimpleStringProperty(endereco);
    }

    public String getIdCliente() {
        return idCliente.get();
    }

    public void setIdCliente(String idCliente) {
        this.idCliente.set(idCliente);
    }

    public String getNome() {
        return nome.get();
    }

    public void setNome(String nome) {
        this.nome.set(nome);
    }

    public String getCpf() {
        return cpf.get();
    }

    public void setCpf(String cpf) {
        this.cpf.set(cpf);
    }

    public String getEndereco() {
        return endereco.get();
    }

    public void setEndereco(String endereco) {
        this.endereco.set(endereco);
    }

    public String getTelefone() {
        return telefone.get();
    }

    public void setTelefone(String telefone) {
        this.telefone.set(telefone);
    }

    public String getEmail() {
        return email.get();
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    @Override
    public String toString() {
        return "tabPessoa{" + "idCliente=" + idCliente + ", nome=" + nome + ", cpf=" + cpf + ", telefone=" + telefone + ", email=" + email + ", endereco=" + endereco + '}';
    }
    
    

}
