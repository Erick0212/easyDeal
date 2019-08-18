/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.dao.ProdutoDao;

/**
 * FXML Controller class
 *
 * @author Erick Nagoski
 */
public class RemoverProdutoController implements Initializable {

    @FXML
    private TextField txtNome;
    @FXML
    private Label lblNome;
    @FXML
    private Label lblValor;
    @FXML
    private Label lblCategoria;
    @FXML
    private Label lblEstoque;
    @FXML
    private Label lblGarantia;
    @FXML
    private Label lblValidade;
    @FXML
    private Button btnRemover;
    @FXML
    private Button btnCancelar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void btnRemoverAction(ActionEvent event) throws SQLException, IOException {
        ProdutoDao dao = new ProdutoDao();

        if (dao.deleteProduto(txtNome.getText())) {
            util.AlertClass.AlertProdutoRemovido();
            btnCancelar.getScene().getWindow().hide();
        }
    }

    @FXML
    private void btnCancelarAction(ActionEvent event) {
        btnCancelar.getScene().getWindow().hide();
    }

}
