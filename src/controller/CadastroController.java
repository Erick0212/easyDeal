/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import util.AlertClass;
import util.Cliente;
import util.Empresa;
import util.Funcoes;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.dao.UserDAO;

/**
 *
 * @author Erick Nagoski
 */
public class CadastroController implements Initializable {

    @FXML
    private PasswordField txtSenha;
    @FXML
    private PasswordField txtConfirma;
    @FXML
    private TextField txtNome;
    @FXML
    private TextField txtTelefone;
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtCpf;
    @FXML
    private TextField txtEndereco;
    @FXML
    private Button btnConfirma;
    @FXML
    private CheckBox cbTermos;
    @FXML
    private Button bntCancelar;

    @FXML
    private void btnConfirmaAction(ActionEvent event) throws SQLException {

        if (cbTermos.isSelected()) {
            recebeInfCliente();
        } else {
            AlertClass.AlertTermos();
        }
    }

    @FXML
    private void btnCancelarAction(ActionEvent event) {
        ((Stage) bntCancelar.getScene().getWindow()).hide();
    }

    public void recebeInfCliente() throws SQLException {
        //recebe  e valida nome
        String nome = (Funcoes.verificaDados(txtNome)) ? txtNome.getText() : null;
        //recebe e valida telefone
        String telefone = (Funcoes.verificaDados(txtTelefone)) ? txtTelefone.getText() : null;
        //recebe e valida cpf
        long cpf = (Funcoes.verificaCPF(txtCpf)) ? Long.parseLong(txtCpf.getText()) : 0;
        if (cpf == 0) {
            AlertClass.AlertCPF();
        }
        //recebe e valida senha
        String senha = (Funcoes.verificaSenha(txtSenha.getText(), txtConfirma.getText())) ? txtSenha.getText() : null;
        if (senha == null) {
            AlertClass.AlertSenha();
        }
        //recebe e valida email
        String email = (Funcoes.validarEmail(txtEmail)) ? txtEmail.getText() : null;
        if (email == null) {
            AlertClass.AlertEmail();
        }
        //recebe e valida endereço
        String endereco = (Funcoes.verificaDados(txtEndereco)) ? txtEndereco.getText() : null;
        String CPF = "" + cpf;
        if (nome != null && senha != null && telefone != null && cpf != 0 && email != null && endereco != null && CPF.length() == 11) {
            salvaCliente(nome, cpf, senha, telefone, email, endereco);
        }
        if (nome != null && senha != null && telefone != null && cpf != 0 && email != null && endereco != null && CPF.length() > 11) {
            salvaEmpresa(nome, cpf, senha, telefone, email, endereco);
        } else {
            AlertClass.AlertDadosInvalidos();
        }
    }

    public void salvaCliente(String nome, long cpf, String senha, String telefone, String email,
            String endereco) throws SQLException {
        Cliente c = Funcoes.criaCliente(nome, cpf, senha, telefone, email, endereco);
        UserDAO dao = new UserDAO();
        if (dao.saveCliente(c)) {
            AlertClass.AlertCadastrado();
            ((Stage) btnConfirma.getScene().getWindow()).hide();
        }
    }

    public void salvaEmpresa(String nome, long cnpj, String senha, String telefone,
            String email, String endereco) throws SQLException {
        Empresa e = Funcoes.criaEmpresa(nome, cnpj, senha, senha, telefone, email, endereco);
        UserDAO dao = new UserDAO();
        if (dao.saveEmpresa(e)) {
            AlertClass.AlertCadastrado();
            ((Stage) btnConfirma.getScene().getWindow()).hide();
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}
