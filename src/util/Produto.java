/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import javafx.scene.image.Image;

/**
 *
 * @author Erick Nagoski
 */
public class Produto {

    private String nome;
    private float valor;
    private boolean promocao;
    private int qntdEstoque;
    private InputImg img;
    private Image imagem;
    private String descricao;
    private String categoria;
    private int validade;
    private int garantia;
    private String tamanhos;
    private String empresa;

    public Produto(String nome, float valor, String categoria, boolean promo, int qntd, InputImg img, String descricao,
            int garantia, int validade, String tamanhos, String empresa) {
        this.categoria = categoria;
        this.descricao = descricao;
        this.empresa = empresa;
        this.garantia = garantia;
        this.img = img;
        this.nome = nome;
        this.promocao = promo;
        this.qntdEstoque = qntd;
        this.tamanhos = tamanhos;
        this.validade = validade;
        this.valor = valor;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getValor() {
        return this.valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public boolean isPromocao() {
        return promocao;
    }

    public void setPromocao(boolean promocao) {
        this.promocao = promocao;
    }

    public boolean getPromocao() {
        return this.promocao;
    }

    public int getQntdEstoque() {
        return qntdEstoque;
    }

    public void setQntdEstoque(int qntdEstoque) {
        this.qntdEstoque = qntdEstoque;
    }

    public Image getImagem() {
        return imagem;
    }

    public void setImagem(Image imagem) {
        this.imagem = imagem;
    }

    public InputImg getImg() {
        return img;
    }

    public void setImg(InputImg img) {
        this.img = img;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getValidade() {
        return validade;
    }

    public void setValidade(int validade) {
        this.validade = validade;
    }

    public int getGarantia() {
        return garantia;
    }

    public void setGarantia(int garantia) {
        this.garantia = garantia;
    }

    public String getTamanhos() {
        return tamanhos;
    }

    public void setTamanhos(String tamanhos) {
        this.tamanhos = tamanhos;
    }

    public Produto(String nome, float valor, String categoria, 
            boolean promocao, int qntdEstoque, InputImg img, String descricao,int garantia, int validade, String tamanhos) {
        this.nome = nome;
        this.valor = valor;
        this.categoria = categoria;
        this.promocao = promocao;
        this.qntdEstoque = qntdEstoque;
        this.img = img;
        this.garantia = garantia;
        this.descricao = descricao;
        this.validade = validade;
        this.tamanhos = tamanhos;
    }

    public Produto(String nome, float valor, boolean promocao, int qntdEstoque, Image imagem, String descricao,
            String categoria) {
        this.nome = nome;
        this.valor = valor;
        this.promocao = promocao;
        this.qntdEstoque = qntdEstoque;
        this.imagem = imagem;
        this.descricao = descricao;
        this.categoria = categoria;
    }

    public Produto(String nome, float valor, boolean promocao, int qntdEstoque, Image imagem, String descricao,
            String categoria, int validade, String empresa) {
        this.nome = nome;
        this.valor = valor;
        this.promocao = promocao;
        this.qntdEstoque = qntdEstoque;
        this.imagem = imagem;
        this.descricao = descricao;
        this.categoria = categoria;
        this.validade = validade;
        this.empresa = empresa;
    }

    public Produto(String nome, float valor, boolean promocao, int qntdEstoque, Image imagem, String descricao,
            String categoria, String tamanhos) {
        this.nome = nome;
        this.valor = valor;
        this.promocao = promocao;
        this.qntdEstoque = qntdEstoque;
        this.imagem = imagem;
        this.descricao = descricao;
        this.categoria = categoria;
        this.tamanhos = tamanhos;
    }

    public Produto(String nome, float valor, boolean promocao, int qntdEstoque, Image imagem, 
            String descricao, String categoria, int validade, int garantia, String tamanhos, String empresa) {
        this.nome = nome;
        this.valor = valor;
        this.promocao = promocao;
        this.qntdEstoque = qntdEstoque;
        this.imagem = imagem;
        this.descricao = descricao;
        this.categoria = categoria;
        this.validade = validade;
        this.garantia = garantia;
        this.tamanhos = tamanhos;
        this.empresa = empresa;
    }
    
    
    
    @Override
    public String toString() {
        return "Produto :" + nome + "\nValor: " + valor + "\nPromocao:" + promocao + "\nCategoria: " + categoria + "\nQntdEstoque: " + qntdEstoque;
    }

}
