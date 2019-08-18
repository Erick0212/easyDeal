/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import tabClasses.tabPessoa;

/**
 * FXML Controller class
 *
 * @author 05200245
 */
public class PainelAdmController implements Initializable {

    @FXML
    private TableView<?> tbNovosProdutos;
    @FXML
    private TableColumn<?, ?> tbProdutosColID;
    @FXML
    private TableColumn<?, ?> tbProdutosColNome;
    @FXML
    private TableColumn<?, ?> tbProdutosColValor;
    @FXML
    private TableColumn<?, ?> tbProdutosColQtndEstoque;
    @FXML
    private TableColumn<?, ?> tbProdutosColCategoria;
    @FXML
    private TableColumn<?, ?> tbProdutosColDescricao;
    @FXML
    private TableColumn<?, ?> tbProdutosColPromocao;
    @FXML
    private TableColumn<?, ?> tbProdutosColGarantia;
    @FXML
    private TableColumn<?, ?> tbProdutosColValidade;
    @FXML
    private TableColumn<?, ?> tbProdutosColTamanhos;
    @FXML
    private TableView<tabPessoa> tbClientes;
    @FXML
    private TableColumn<tabPessoa, String> tbClientesColId;
    @FXML
    private TableColumn<tabPessoa, String> tbClientesColNome;
    @FXML
    private TableColumn<tabPessoa, String> tbClientesColCpf;
    @FXML
    private TableColumn<tabPessoa, String> tbClientesColEmail;
    @FXML
    private TableColumn<tabPessoa, String> tbClientesColEndereco;
    @FXML
    private TableColumn<tabPessoa, String> tbClientesColTelefone;
    @FXML
    private TableView<?> tbEmpresa;
    @FXML
    private TableColumn<?, ?> tbEmpresaColId;
    @FXML
    private TableColumn<?, ?> tbEmpresaColNome;
    @FXML
    private TableColumn<?, ?> tbEmpresaColCnpj;
    @FXML
    private TableColumn<?, ?> tbEmpresaColEmail;
    @FXML
    private TableColumn<?, ?> tbEmpresaColTelefone;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
