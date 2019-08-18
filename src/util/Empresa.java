/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.Objects;

/**
 *
 * @author Erick Nagoski
 */
public class Empresa extends Pessoa{
    private long cnpj;
 
    public long getCnpj (){
        return cnpj;
    }

    public void setCnpj(long cnpj) {
        this.cnpj = cnpj;
    }

    public Empresa(String nome,long cnpj, String senha, String telefone, String email,String endereco,String tipo) {
        super(nome,senha,telefone,email,endereco,tipo);
        this.cnpj = cnpj;
    }

    @Override
    public String toString() {
        return "Empresa: " + nome + "\nCNPJ: " + cnpj + "\nCódigo da Empresa: "+ "\nTelefone: " + telefone + "\nE-mail=" + email;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Empresa other = (Empresa) obj;
        if (this.cnpj != other.cnpj) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.senha, other.senha)) {
            return false;
        }
        if (!Objects.equals(this.telefone, other.telefone)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        return true;
    }
    
    
    
    
    
}
