/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.dao.EncomendaDao;
import util.Encomenda;
import util.Funcoes;

/**
 * FXML Controller class
 *
 * @author Erick Nagoski
 */
public class NovaEncomendaController implements Initializable {

    @FXML
    private TextField txtNome;
    @FXML
    private TextArea txtDescricao;
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
    private Button btnEncomendar;
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
    private void btnEncomendarAction(ActionEvent event) {
        Map user =null;
        user = Funcoes.load();
        
        Encomenda encomenda = new Encomenda(txtNome.getText(), txtDescricao.getText(), (String) user.get("nome"), categoria());
        try {
            EncomendaDao dao  = new EncomendaDao();
            dao.saveEncomenda(encomenda);
        } catch (SQLException ex) {
            Logger.getLogger(NovaEncomendaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println(encomenda.toString());
        System.out.println("salvo");
    }
    
    public  String categoria(){
        if(menItemAlimento.isSelected()){
            return "Alimento";
        }
        if(menItemCasa.isSelected()){
            return "Casa e decorração";
        }
        if(menItemCultura.isSelected()){
            return "Cultura";
        }
        if(menItemEletro.isSelected()){
            return "Eletro";
        }
        if(menItemEletronicos.isSelected()){
            return "Eletronicos";
        }
        if(menItemEntretenimento.isSelected()){
            return "Entretenimento";
        }
        if(menItemFerramentas.isSelected()){
            return "Ferramentas";
        }
        if(menItemInfantil.isSelected()){
            return "Infantil";
        }
        if(menItemInformatica.isSelected()){
            return "Informatica";
        }
        if(menItemJardim.isSelected()){
            return "Jardim";
        }
        if(menItemOutros.isSelected()){
            return "Outros";
        }
        if(menItemRoupas.isSelected()){
            return "Roupas";
        }
        if(menItemSaude.isSelected()){
            return "Saude";
        }
        return "null";
    }

    @FXML
    private void btnCancelarAction(ActionEvent event) {
        btnCancelar.getScene().getWindow().hide();
    }
    
}
