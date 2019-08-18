/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import util.Funcoes;

/**
 * FXML Controller class
 *
 * @author 05200245
 */
public class PainelEmpresaController implements Initializable {

    @FXML
    private Button btnAddProduto;
    @FXML
    private Button btnRemoveProduto;
    @FXML
    private Button btnEncomendas;
    @FXML
    private Button btnPedidos;
    @FXML
    private Button btnConta;
    @FXML
    private AnchorPane rightPane;
    @FXML
    private Button btnModificaProduto;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void btnAddProdutoAction(ActionEvent event) throws IOException {
        Funcoes func = new Funcoes();
        func.abrirJanela("/view/cadastra.fxml");
    }

    @FXML
    private void btnRemoveProdutoAction(ActionEvent event) throws IOException {
        Funcoes func = new Funcoes();
        func.abrirJanela("/view/removerProduto.fxml");
    }

    @FXML
    private void btnEncomendasAction(ActionEvent event) throws IOException {
        Funcoes func = new Funcoes();
        func.abrirJanela("/view/cadastra.fxml");
    }

    private void btnNewOfertaAction(ActionEvent event) throws IOException {
        Funcoes func = new Funcoes();
        func.abrirJanela("/view/cadastra.fxml");
    }

    @FXML
    private void btnPedidosAction(ActionEvent event) throws IOException {
        Funcoes func = new Funcoes();
        func.abrirJanela("/view/cadastra.fxml");
    }

    @FXML
    private void btnContaAction(ActionEvent event) throws IOException {
        Funcoes func = new Funcoes();
        func.abrirJanela("/view/cadastra.fxml");
    }

    @FXML
    private void btnModificaProdutoAction(ActionEvent event) {
    }

}
