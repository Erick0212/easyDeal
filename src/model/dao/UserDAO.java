/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import util.Cliente;
import conexao.ConnectionFactory;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.image.Image;
import tabClasses.tabPessoa;
import util.Empresa;
import util.Funcoes;
import util.Produto;

/**
 *
 * @author tecnica
 */
public class UserDAO {

    private Connection con = null;

    public UserDAO() throws SQLException {
        con = ConnectionFactory.getConnection();
    }

    public boolean saveCliente(Cliente user) throws SQLException {
        Connection con = ConnectionFactory.getConnection();
        String sql = "INSERT INTO tbCliente (nome,senha,cpf,telefone,email,tipo,endereco) VALUES (?,?,?,?,?,?)";

        PreparedStatement stmt = null;

        try {
            stmt = (PreparedStatement) con.prepareStatement(sql);

            stmt.setString(1, user.getNome());
            stmt.setString(2, user.getSenha());
            stmt.setString(3, "" + user.getCpf());
            stmt.setString(4, user.getTelefone());
            stmt.setString(5, user.getEmail());
            stmt.setString(6, user.getEndereco());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro " + ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public boolean saveEmpresa(Empresa emp) throws SQLException {
        Connection con = ConnectionFactory.getConnection();
        String sql = "INSERT INTO tbEmpresa (nome,senha,cpf,telefone,email,endereco) VALUES (?,?,?,?,?,?)";

        PreparedStatement stmt = null;

        try {
            stmt = (PreparedStatement) con.prepareStatement(sql);

            stmt.setString(1, emp.getNome());
            stmt.setString(2, emp.getSenha());
            stmt.setString(3, "" + emp.getCnpj());
            stmt.setString(4, emp.getTelefone());
            stmt.setString(5, emp.getEmail());
            stmt.setString(6, emp.getEndereco());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro " + ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public boolean buscarCliente(String email, String senha) throws IOException {
        String sql = "SELECT email, senha,nome, idCliente FROM tbCliente WHERE email = '" + email + "' and senha ='" + senha + "'";

        String id = "";
        String nome = "";
        String Email = "";
        try (PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                nome = rs.getString("nome");
                Email = rs.getString("email");
                id = rs.getString("idCliente");
                Funcoes.UserSessao(nome, Email, id);
                return true;
            }

        } catch (SQLException ex) {
            System.err.println("Erro " + ex);
        }
        return false;
    }

    public boolean buscarEmpresa(String email, String senha) throws IOException {
        String sql = "SELECT email, senha,nome, idEmpresa FROM tbEmpresa WHERE email = '" + email + "' and senha ='" + senha + "'";

        String nome = "";
        String Email = "";
        String id = "";
        try (PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                nome = rs.getString("nome");
                Email = rs.getString("email");
                id = rs.getString("idEmpresa");
                Funcoes.UserSessao(nome, Email, id);
                return true;
            }

        } catch (SQLException ex) {
            System.err.println("Erro " + ex);
        }
        return false;
    }

    public ArrayList carregaClientes() {
        String sql = "SELECT * FROM tbCliente";

        try (PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();

            ArrayList<tabPessoa> clientes = new ArrayList();
            while (rs.next()) {

                String idCliente = rs.getString("idCliente");
                String nome = rs.getString("nome");
                String cpf = rs.getString("cpf");
                String telefone = rs.getString("telefone");
                String email = rs.getString("email");
                String endereco = rs.getString("endereco");
                if (rs != null) {
                    tabPessoa tp = new tabPessoa(idCliente, nome, cpf, telefone, email, endereco);
                    clientes.add(tp);
                }
                return clientes;
            }

        } catch (SQLException ex) {
            System.err.println("Erro " + ex);
        }
        return null;

    }

    public boolean buscaAdm(String email, String senha) throws IOException {
        String sql = "SELECT email, senha,nome, idAdm FROM tbAdm WHERE email = '" + email + "' and senha ='" + senha + "'";

        String nome = "";
        String Email = "";
        String id = "";
        try (PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                nome = rs.getString("nome");
                Email = rs.getString("email");
                id = rs.getString("idAdm");
                Funcoes.UserSessao(nome, Email, id);
                return true;
            }

        } catch (SQLException ex) {
            System.err.println("Erro " + ex);
        }
        return false;

    }

}
