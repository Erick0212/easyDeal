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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import util.Funcoes;

/**
 * FXML Controller class
 *
 * @author erick
 */
public class InicialController implements Initializable {

    @FXML
    private MenuItem LogCliente;
    @FXML
    private MenuItem LogEmpresa;
    @FXML
    private Button btnCadastro;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btnLoginCli(ActionEvent event) throws IOException {
        Funcoes func = new Funcoes();
        func.abrirJanela("/view/Login.fxml");
    }

    @FXML
    private void btnLoginEmp(ActionEvent event) throws IOException {
        Funcoes func = new Funcoes();
        func.abrirJanela("/view/LoginEmp.fxml");
    }

    @FXML
    private void CadastroAction(ActionEvent event) throws IOException {
        //Funcoes.loadWindow(getClass().getResource("teste.fxml"), "teste scene", null);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/Cadastro.fxml"));
        Parent root = loader.load();

        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.getIcons().add(new javafx.scene.image.Image("/Icon/Shop.png"));
        stage.setScene(scene);
        stage.show();
        //CadastroController controller = loader.getController();

    }
    
}
