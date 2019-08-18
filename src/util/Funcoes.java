package util;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import util.Cliente;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Erick Nagoski
 */
public class Funcoes {

    public static Cliente criaCliente(String nome, long cpf, String senha, String telefone, String email, String endereco) {
        Cliente c = new Cliente(nome, cpf, senha, telefone, email, endereco, "cliente");
        return c;
    }

    public static Empresa criaEmpresa(String nome, long cnpj, String senha, String confirma, String telefone, String email, String endereco) {
        Empresa e = new Empresa(nome, cnpj, senha, telefone, email, endereco, "empresa");
        return e;
    }

    public static boolean verificaCheckBox(CheckBox cbFisica, CheckBox cbJuridica) {
        if (cbFisica.isSelected() && cbJuridica.isSelected()) {
            AlertClass.AlertPersonType();
            return false;
        }
        return true;
    }

    public static boolean verificaCPF(TextField txtCPF) {
        if (txtCPF.getText().length() >= 11) {
            return true;
        }
        return false;
    }

    public static boolean verificaDados(TextField entrada) {
        String txt = entrada.getText();
        if (verificaString(txt)) {
            return true;
        } else {
            AlertClass.AlertDadosInvalidos();
        }
        return false;
    }

    public static boolean verificaString(String string) {
        if (string.equalsIgnoreCase("")) {
            return false;
        }
        return true;
    }

    public static long geradorDeID(Long cpf) {
        GregorianCalendar calendar = new GregorianCalendar();
        int hora = calendar.get(calendar.HOUR_OF_DAY);
        if (hora < 10) {
            hora += 10;
        }
        int minuto = calendar.get(calendar.MINUTE);
        if (minuto < 10) {
            minuto += 10;
        }
        String cod = Integer.toString(hora) + Integer.toString(minuto);

        char[] cpfChar = cpf.toString().toCharArray();
        cod = cod + cpfChar[0] + cpfChar[2] + cpfChar[4];

        long codigo = Long.parseLong(cod);

        return codigo;
    }

    public static boolean verificaSenha(String senha, String confirmacao) {
        if (senha.equalsIgnoreCase(confirmacao) && senha.length() > 3) {
            return true;
        }
        return false;
    }

    public static boolean validarEmail(TextField txtEmail) {
        String email = txtEmail.getText();
        boolean isEmailIdValid = false;
        if (email != null && email.length() > 0) {
            String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
            Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(email);
            if (matcher.matches()) {
                isEmailIdValid = true;
            }
        }
        return isEmailIdValid;
    }

    public void abrirJanela(String caminho) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(caminho));
        Parent root = loader.load();

        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.getIcons().add(new javafx.scene.image.Image("/Icon/Shop.png"));
        stage.setScene(scene);
        stage.show();

    }

    public static void carregaImg(byte[] img) {
        // byte[] imgBytes = rs.getBytes("binaryfile");
        try {
            FileOutputStream fos = new FileOutputStream("C:/imagens/teste.jpeg");
            fos.write(img);
            FileDescriptor fd = fos.getFD();
            fos.flush();
            fd.sync();
            fos.close();
        } catch (Exception e) {
            String erro = e.toString();
        }

    }

    public static byte[] converteImg(String caminho) throws IOException {
        InputStream is = null;
        byte[] buffer = null;
        is = new FileInputStream(caminho);
        buffer = new byte[is.available()];
        is.read(buffer);
        is.close();
        return buffer;

    }

    public static InputImg selecionaImg(Window janela) throws IOException {
        FileChooser fileChooser = new FileChooser();

        fileChooser.setTitle("imagem");
        fileChooser.setInitialDirectory(new File("C:\\Users\\" + System.getProperty("user.name") + "\\Desktop"));
        //fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("JPG", "jpg"));
        //fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("PNG", "png"));
        //fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("JPEG","jpeg"));
        String caminho = fileChooser.showOpenDialog(janela).getAbsolutePath();

        File file = new File(caminho);
        FileInputStream input = new FileInputStream(file);

        InputImg img = new InputImg(file, input);

        return img;

    }

    public static void writeMap(Map<String, String> map) throws IOException {
        Path path = Files.createTempFile("sessao", ".txt");
        try (XMLEncoder encoder = new XMLEncoder(
                new BufferedOutputStream(
                        Files.newOutputStream(path)))) {

            final Exception[] exception = {null};
            encoder.setExceptionListener(e -> exception[0] = e);
            encoder.writeObject(map);

            if (exception[0] != null) {
                throw new IOException(exception[0]);
            }
        }
    }

    public static synchronized void save(HashMap<String, String> map) {
        File f = new File("sessao.txt");
        if (!(f.exists())) {
            try {
                f.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f))) {
            oos.writeObject((HashMap<String, String>) map);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static HashMap<String, String> load() {
        File f = new File("sessao.txt");
        if (f.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))) {
                HashMap<String, String> map = (HashMap<String, String>) ois.readObject();
                return map;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    
    public static void main(String[] args) throws ClassNotFoundException, IOException {
        Map<String,String> mapa = load();
        System.out.println(mapa.get("nome"));
        System.out.println(mapa.get("idCliente"));
        System.out.println(mapa.get("email"));
    }

    public static Map<String, String> readMap() throws IOException, ClassNotFoundException {
        File f = new File("sessao.txt");
        if (f.exists()) {
            try(FileInputStream fis = new FileInputStream(f); ObjectInputStream ois =new ObjectInputStream(fis)){

                Map<String, String> map = (Map<String, String>) ois.readObject();
                return map;
            }
        }
        return null;
    }

    public static void UserSessao(String nome, String Email, String id) throws IOException {
        HashMap<String, String> map = new HashMap();
        map.put("nome", nome);
        map.put("email", Email);
        map.put("id", id);
        save(map);
    }

    public static boolean verificaFloat(String valor) {

        if (valor.isEmpty()) {
            return false;
        }

        ArrayList<String> alfabeto = new ArrayList();
        alfabeto.add("a");
        alfabeto.add("m");
        alfabeto.add("b");
        alfabeto.add("n");
        alfabeto.add("c");
        alfabeto.add("o");
        alfabeto.add("d");
        alfabeto.add("p");
        alfabeto.add("e");
        alfabeto.add("q");
        alfabeto.add("f");
        alfabeto.add("r");
        alfabeto.add("g");
        alfabeto.add("s");
        alfabeto.add("h");
        alfabeto.add("t");
        alfabeto.add("i");
        alfabeto.add("u");
        alfabeto.add("j");
        alfabeto.add("v");
        alfabeto.add("k");
        alfabeto.add("w");
        alfabeto.add("l");
        alfabeto.add("x");
        alfabeto.add("y");
        alfabeto.add("z");

        for (int i = 0; i < alfabeto.size(); i++) {
            if (valor.contains(alfabeto.get(i))) {
                return false;
            }
        }

        return true;
    }

    public static String tiraVirgula(String valor) {
        if (valor.contains(",")) {
            valor.replace(",", ".");
        }
        return valor;
    }
}
