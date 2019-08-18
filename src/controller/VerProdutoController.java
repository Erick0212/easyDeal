/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import util.Produto;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import model.dao.ProdutoDao;

/**
 * FXML Controller class
 *
 * @author Erick_Nagoski
 */
public class VerProdutoController implements Initializable {

    @FXML
    private AnchorPane img;
    @FXML
    private ImageView imgProd;
    @FXML
    private Label lblPreco;
    @FXML
    private Label lblTitulo;
    @FXML
    private Slider SldQtnd;
    @FXML
    private Label lblDescricao;
    @FXML
    private Pane pnlVestuario;
    @FXML
    private Button btnAddCart;
    @FXML
    private ImageView imgProdAle;
    @FXML
    private ImageView imgProdAle2;
    @FXML
    private Button btnCarregaImg;
    @FXML
    private Label lblCategoria;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void carregaImgAction(ActionEvent event) throws SQLException, IOException {
        setImg(imgProd);
    }
    
    private void setImg(ImageView imgView) throws SQLException, IOException{
        
        
        ProdutoDao dao = new ProdutoDao();
        
        Produto p = dao.getProdutoBD("Geladeira");
        
        lblTitulo.setText(p.getNome());
        lblPreco.setText(String.valueOf( p.getValor()));
        lblDescricao.setText(p.getDescricao());
        lblCategoria.setText(p.getCategoria());
        imgView.setImage(p.getImagem());
        
        
        ///String nome = "Geladeira";
        
        ///Image image = dao.getImgBD(nome);
      
        
        
    }
    
}
