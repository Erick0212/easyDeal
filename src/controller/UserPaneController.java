/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import util.Funcoes;
import util.Produto;

/**
 * FXML Controller class
 *
 * @author Erick Nagoski
 */
public class UserPaneController implements Initializable {

    @FXML
    private Button btnCart;
    @FXML
    private Button btnPedidos;
    @FXML
    private Button btnEncomendas;
    @FXML
    private Button btnNewEncomenda;
    @FXML
    private Button btnEmpresas;
    @FXML
    private Button btnConta;
    @FXML
    private AnchorPane rightPane;
    @FXML
    private AnchorPane rightPane1;
    @FXML
    private AnchorPane rightPane11;
    @FXML
    private TableColumn<Produto, Integer> ColId;
    @FXML
    private TableColumn<Produto, String> ColNome;
    @FXML
    private TableColumn<Produto, String> ColEmpresa;
    @FXML
    private TableColumn<Produto, Integer> ColEstoque;
    @FXML
    private TableColumn<Produto, Float> ColValor;
    @FXML
    private TableColumn<Produto, String> ColCategoria;
    @FXML
    private TableColumn<Produto, String> ColDescricao;
    @FXML
    private TableView<Produto> tbProdutos;



    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ColId.setCellValueFactory(
                new PropertyValueFactory<>("id"));
        ColNome.setCellValueFactory(
                new PropertyValueFactory<>("nome"));
        ColEmpresa.setCellValueFactory(
                new PropertyValueFactory<>("empresa"));
        ColValor.setCellValueFactory(
                new PropertyValueFactory<>("valor"));
        ColCategoria.setCellValueFactory(
                new PropertyValueFactory<>("categoria"));
        ColDescricao.setCellValueFactory(
                new PropertyValueFactory<>("descricao"));
        ColEstoque.setCellValueFactory(
                new PropertyValueFactory<>("qntdEstoque"));
        
        tbProdutos.setItems(listaDeProdutos());
        // TODO
    }    
    
    private ObservableList<Produto> listaDeProdutos(){
        return FXCollections.observableArrayList(
                new Produto("batata", 0, true, 0, null, "gfgf", "gffgfgf"),
                new Produto("Bruo", 19, false,9,null,"dfdfd","108")
                );
    }

    @FXML
    private void btnCarrinhoAction(ActionEvent event) {
    }

    @FXML
    private void btnMyPedidosAction(ActionEvent event) {
    }

    @FXML
    private void btnEncomendasAction(ActionEvent event) {
    }

    @FXML
    private void btnNewEncomendaAction(ActionEvent event) {
         Funcoes func = new Funcoes();
        try {
            func.abrirJanela("/view/NovaEncomenda.fxml");
        } catch (IOException ex) {
            Logger.getLogger(UserPaneController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void btnEmpresasAction(ActionEvent event) {
    }

    @FXML
    private void btnContaAction(ActionEvent event) {
    }

    

    
}
