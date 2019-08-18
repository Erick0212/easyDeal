/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import util.Funcoes;
import util.InputImg;
import util.Produto;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import model.dao.ProdutoDao;

/**
 * FXML Controller class
 *
 * @author 05200245
 */
public class CadastraProdutoController implements Initializable {

    @FXML
    private TextField txtQntdEstoque;

    @FXML
    private TextField txtGarantia;

    @FXML
    private TextField txtValidade;

    @FXML
    private TextField txtNome;

    @FXML
    private ImageView imgView;

    @FXML
    private TextField txtValor;

    @FXML
    private Button btnSelecionar;
    @FXML
    private RadioButton cbPromo;
    @FXML
    private CheckBox cbPP;
    @FXML
    private CheckBox cbP;
    @FXML
    private CheckBox cbM;
    @FXML
    private CheckBox cbGG;
    @FXML
    private CheckBox cbG;
    @FXML
    private CheckBox cbTds;
    @FXML
    private TextArea txtDescricao;
    @FXML
    private Button btnFinalizar;
    @FXML
    private RadioMenuItem menItemAlimento;
    @FXML
    private RadioMenuItem menItemEletronicos;
    @FXML
    private RadioMenuItem menItemInformatica;
    @FXML
    private RadioMenuItem menItemEntretenimento;
    @FXML
    private RadioMenuItem menItemRoupas;
    @FXML
    private RadioMenuItem menItemCasa;
    @FXML
    private RadioMenuItem menItemEletro;
    @FXML
    private RadioMenuItem menItemInfantil;
    @FXML
    private RadioMenuItem menItemCultura;
    @FXML
    private RadioMenuItem menItemSaude;
    @FXML
    private RadioMenuItem menItemFerramentas;
    @FXML
    private RadioMenuItem menItemJardim;
    @FXML
    private RadioMenuItem menItemOutros;

    @FXML
    void btnSelecionarAction(ActionEvent event) throws IOException, SQLException, ClassNotFoundException {

        Produto p = criaProduto();
        salvaProduto(p);
    }

    @FXML
    void btnFinalizar(ActionEvent event) throws IOException, SQLException, ClassNotFoundException {
        String emp = getEmpresa();
        System.out.println(emp);
    }

   
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    public String categoria() {
        if (menItemAlimento.isSelected()) {
            return "Alimento";
        }
        if (menItemCasa.isSelected()) {
            return "Casa e decorração";
        }
        if (menItemCultura.isSelected()) {
            return "Cultura";
        }
        if (menItemEletro.isSelected()) {
            return "Eletro";
        }
        if (menItemEletronicos.isSelected()) {
            return "Eletronicos";
        }
        if (menItemEntretenimento.isSelected()) {
            return "Entretenimento";
        }
        if (menItemFerramentas.isSelected()) {
            return "Ferramentas";
        }
        if (menItemInfantil.isSelected()) {
            return "Infantil";
        }
        if (menItemInformatica.isSelected()) {
            return "Informatica";
        }
        if (menItemJardim.isSelected()) {
            return "Jardim";
        }
        if (menItemOutros.isSelected()) {
            return "Outros";
        }
        if (menItemRoupas.isSelected()) {
            return "Roupas";
        }
        if (menItemSaude.isSelected()) {
            return "Saude";
        }
        return "null";
    }

    public Produto criaProduto() throws IOException, ClassNotFoundException {
        String nome = (Funcoes.verificaString(txtNome.getText()))? txtNome.getText():null;

        float valor = (Funcoes.verificaFloat(txtValor.getText()))? Float.parseFloat(Funcoes.tiraVirgula(txtValor.getText())):null;

        String categoria = categoria();

        boolean promo = false;
        if (cbPromo.isSelected()) {
            promo = true;
        }

        String descricao = (!txtDescricao.getText().isEmpty())?txtDescricao.getText():null;

        int garantia =  (Funcoes.verificaFloat(txtGarantia.getText()))?Integer.parseInt(txtGarantia.getText()):null;

        int qntd = (Funcoes.verificaFloat(txtQntdEstoque.getText()))?Integer.parseInt(txtQntdEstoque.getText()):null;

        int validade = (Funcoes.verificaFloat(txtValidade.getText()))?Integer.parseInt(txtValidade.getText()):null;

        String tamanhos = getTamanhos();

        InputImg img = Funcoes.selecionaImg(btnSelecionar.getScene().getWindow());
        
        
        
        String empresa = getEmpresa();

        Produto p = new Produto(nome, valor, categoria, promo, qntd, img, descricao, garantia, validade, tamanhos,empresa);

        System.out.println(p.toString());

        return p;
    }

    public static void salvaProduto(Produto p) throws SQLException {
        ProdutoDao dao = new ProdutoDao();
        dao.saveNewProduto(p);
        System.out.println("SALVOU");

    }

    private String getTamanhos() {
        String tamanhos = null;
        if (cbGG.isSelected()) {
            tamanhos = tamanhos + " GG,";
        }
        if (cbG.isSelected()) {
            tamanhos = tamanhos + " G,";
        }
        if (cbM.isSelected()) {
            tamanhos = tamanhos + " M,";
        }
        if (cbP.isSelected()) {
            tamanhos = tamanhos + " P,";
        }
        if (cbPP.isSelected()) {
            tamanhos = tamanhos + " PP,";
        }
        if (cbTds.isSelected()) {
            tamanhos = "P,M,G,GG";
        }

        return tamanhos;
    }
    
    public static String getEmpresa() throws IOException, ClassNotFoundException{
        Map<String, String> sessao = Funcoes.readMap();
        return sessao.get("nome");
    }
}
