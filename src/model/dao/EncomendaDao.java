/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import conexao.ConnectionFactory;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import util.Encomenda;

/**
 *
 * @author Erick Nagoski
 */
public class EncomendaDao {
    
    
    private Connection con = null;

    public EncomendaDao() throws SQLException {
        con = ConnectionFactory.getConnection();
    }

    public boolean saveEncomenda(Encomenda encomenda) throws SQLException {

        String sql = "INSERT INTO encomendas (nome,categoria,descricao,user) VALUES (?,?,?,?);";
        PreparedStatement stmt = null;

        try {
            stmt = (PreparedStatement) con.prepareStatement(sql);

            stmt.setString(1, encomenda.getTitulo());
            stmt.setString(2, encomenda.getCategoria());
            stmt.setString(3, encomenda.getDescricao());
            stmt.setString(4, encomenda.getUser());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro " + ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
}
