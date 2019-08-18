/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import util.AlertClass;
import util.Cliente;
import util.Funcoes;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.dao.UserDAO;

/**
 * FXML Controller class
 *
 * @author Erick Nagoski
 */
public class LoginController implements Initializable {

    @FXML
    private Button btnEntrar;
    @FXML
    private Button btnCancelar;
    @FXML
    private Button btnCadastro;
    @FXML
    private PasswordField txtSenha;
    @FXML
    private TextField txtEmail;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void CadastroAction(ActionEvent event) throws IOException {
        
    }

    @FXML
    void btnEntrar(ActionEvent event) throws IOException, SQLException {
        String email = "";
        if (Funcoes.validarEmail(txtEmail)) {
            email = txtEmail.getText();
        } else {
            AlertClass.AlertEmail();
        }

        String senha = txtSenha.getText();

        UserDAO dao = new UserDAO();

        Funcoes func = new Funcoes();
        
        if(dao.buscarCliente(email, senha)){
                func.abrirJanela("/view/userPane.fxml");
            txtSenha.getScene().getWindow().hide();
        }if(dao.buscaAdm(email,senha)){
            func.abrirJanela("/view/painelAdm.fxml");
            txtSenha.getScene().getWindow().hide();
        }
        else{
            AlertClass.naoCadastrado();
        }

    }

    @FXML
    private void btnCancelarAction(ActionEvent event) {
        ((Stage) btnCancelar.getScene().getWindow()).hide();
    }
}
