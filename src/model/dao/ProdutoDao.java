/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import util.Produto;
import java.sql.PreparedStatement;
import conexao.ConnectionFactory;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javax.imageio.ImageIO;
import tabClasses.tabPessoa;

/**
 *
 * @author 05200245
 */
public class ProdutoDao {

    private Connection con = null;

    public ProdutoDao() throws SQLException {
        con = ConnectionFactory.getConnection();
    }

    public boolean saveNewProduto(Produto p) throws SQLException {
        String sql = "INSERT INTO novoproduto (nome,valor,qtndEstoque,categoria,descricao,img,promocao,garantia,validade,tamanhos,empresa) "
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?);";
        PreparedStatement stmt = null;

        try {
            stmt = (PreparedStatement) con.prepareStatement(sql);

            stmt.setString(1, p.getNome());
            stmt.setString(2, "" + p.getValor());
            stmt.setString(3, "" + p.getQntdEstoque());
            stmt.setString(4, p.getCategoria());
            stmt.setString(5, p.getDescricao());
            stmt.setBinaryStream(6, (InputStream) p.getImg().getFis(), (int) p.getImg().getFile().length());
            stmt.setString(7, "'" + p.getPromocao() + "'");
            stmt.setString(8, "" + p.getGarantia());
            stmt.setString(9, "" + p.getValidade());
            stmt.setString(10, p.getTamanhos());
            stmt.setString(11, p.getEmpresa());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro " + ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public boolean saveProduto(Produto p) throws SQLException {

        String sql = "INSERT INTO produtos (nome,valor,qtndEstoque,categoria,descricao,img,promocao,garantia,validade,tamanhos) VALUES (?,?,?,?,?,?,?,?,?,?);";
        PreparedStatement stmt = null;

        try {
            stmt = (PreparedStatement) con.prepareStatement(sql);

            stmt.setString(1, p.getNome());
            stmt.setString(2, "" + p.getValor());
            stmt.setString(3, "" + p.getQntdEstoque());
            stmt.setString(4, p.getCategoria());
            stmt.setString(5, p.getDescricao());
            stmt.setBinaryStream(6, (InputStream) p.getImg().getFis(), (int) p.getImg().getFile().length());
            stmt.setString(7, "'" + p.getPromocao() + "'");
            stmt.setString(8, "" + p.getGarantia());
            stmt.setString(9, "" + p.getValidade());
            stmt.setString(10, p.getTamanhos());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro " + ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public ArrayList<tabPessoa> carregar() {
        String sql = "SELECT * FROM tbproduto";

        try (PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {

                String name = rs.getString("nome");
                Float valor = rs.getFloat("valor");
                int qtndEstoque = rs.getInt("qtndEstoque");
                String categoria = rs.getString("categoria");
                String descricao = rs.getString("descricao");
                boolean promo = false;
                if (rs.getString("promocao").equalsIgnoreCase("true")) {
                    promo = true;
                }
                int garantia = Integer.parseInt(rs.getString("garantia"));
                int validade = Integer.parseInt(rs.getString("validade"));
                String tamanhos = rs.getString("Tamanhos");
                String empresa = rs.getString("empresa");
                Image img = null;
                try {
                    img = getImgBD(name);
                } catch (IOException ex) {
                    Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
                }

                Produto p = new Produto(nome, valor, promo, qtndEstoque, img, descricao, categoria, validade, garantia, tamanhos, empresa);
                return p;
            }

        } catch (SQLException ex) {
            System.err.println("Erro " + ex);
        }
        return null;

    }

    public Produto getProdutoBD(String nome) {
        String sql = "SELECT * FROM produtos WHERE nome = '" + nome + "'";

        try (PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {

                String name = rs.getString("nome");
                Float valor = rs.getFloat("valor");
                int qtndEstoque = rs.getInt("qtndEstoque");
                String categoria = rs.getString("categoria");
                String descricao = rs.getString("descricao");
                boolean promo = false;
                if (rs.getString("promocao").equalsIgnoreCase("true")) {
                    promo = true;
                }
                int garantia = Integer.parseInt(rs.getString("garantia"));
                int validade = Integer.parseInt(rs.getString("validade"));
                String tamanhos = rs.getString("Tamanhos");
                String empresa = rs.getString("empresa");
                Image img = null;
                try {
                    img = getImgBD(name);
                } catch (IOException ex) {
                    Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
                }

                Produto p = new Produto(nome, valor, promo, qtndEstoque, img, descricao, categoria, validade, garantia, tamanhos, empresa);
                return p;
            }

        } catch (SQLException ex) {
            System.err.println("Erro " + ex);
        }
        return null;
    }

    public Image getImgBD(String nome) throws IOException {

        String sql = "SELECT img FROM produtos WHERE nome = '" + nome + "'";

        try (PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {

                Blob blob = rs.getBlob("img");
                int blobLength = (int) blob.length();
                byte[] blobAsBytes = blob.getBytes(1, blobLength);
                BufferedImage img1 = ImageIO.read(new ByteArrayInputStream(blobAsBytes));
                Image image = SwingFXUtils.toFXImage(img1, null);

                return image;
            }

        } catch (SQLException ex) {
            System.err.println("Erro " + ex);
        }
        return null;

    }

    public boolean deleteProduto(String nome) throws IOException, SQLException {

        String sql = "DELETE FROM produtos WHERE nome = '" + nome + "'";

        try (PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql)) {
            stmt.executeUpdate();
            return true;

        } catch (SQLException ex) {
            System.err.println("Erro " + ex);
        }
        return false;

    }
}
