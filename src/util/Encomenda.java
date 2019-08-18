/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author Erick Nagoski
 */
public class Encomenda {
    private String titulo;
    private String descricao;
    private String user;
    private String categoria;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Encomenda(String titulo, String descricao, String user, String categoria) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.user = user;
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Encomenda{" + "titulo=" + titulo + ", descricao=" + descricao + ", user=" + user + ", categoria=" + categoria + '}';
    }
    
    
}
