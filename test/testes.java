
import java.sql.SQLException;
import java.util.ArrayList;
import model.dao.UserDAO;
import tabClasses.tabPessoa;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author erick
 */
public class testes {
    
    public static void main(String[] args) throws SQLException {
        UserDAO dao = new UserDAO();
        ArrayList<tabPessoa> clientes = dao.carregaClientes();
        
        for (tabPessoa cliente : clientes) {
            System.out.println(cliente.toString());
            System.out.println("\n");
            
        }
    }
}
