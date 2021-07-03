/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainclass;

import conecctor.databaseuploadmahasiswa;
import java.io.File;
import java.io.FileNotFoundException;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.MessagingException;
import javax.mail.Transport;


/**
 *
 * @author USER
 */
public class dashControllerjadwalPKN {

    @FXML
    private Label data;
    
    public TextField nim1;
    public TextField nama1;
    public TextField nim2;
    public TextField nama2;
    public TextField nim3;
    public TextField nama3;
    public TextField nim4;
    public TextField nama4;
    public TextField programstudi;
    public TextField judul;
    public TextField tempatpkn;
    public TextField waktupelaksanaan;
    public TextField dosenpembimbing;
    public TextField carijudul;
    public TextField coment;

    public TextField emailto;
    public TextField emailfrom;
    public PasswordField password;
    public TextField subject;
    public TextArea message;

    private Stage stage;
    private Scene scene;
    private Parent root;
    
      public void carijudul() throws SQLException {
        Connection conn = databaseuploadmahasiswa.getConnection();
        String query = "select * from user where Judul ='" + carijudul.getText() + "' ";
        Statement st;
        ResultSet rs;
        try {
            st = conn.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                nim1.setText(rs.getString(1));
                nama1.setText(rs.getString(2));
                nim2.setText(rs.getString(3));
                nama2.setText(rs.getString(4));
                nim3.setText(rs.getString(5));
                nama3.setText(rs.getString(6));
                nim4.setText(rs.getString(7));
                nama4.setText(rs.getString(8));
                programstudi.setText(rs.getString(9));
                judul.setText(rs.getString(10));
                tempatpkn.setText(rs.getString(11));
                waktupelaksanaan.setText(rs.getString(12));
                dosenpembimbing.setText(rs.getString(13));
            }
        } catch (Exception e) {

        }
    }

    File selectedFile;

    public void filepenyimpanan(ActionEvent actionevent) throws IOException, FileNotFoundException {
        FileChooser fc = new FileChooser();
        fc.setInitialDirectory(new File("C:\\"));
        fc.getExtensionFilters().addAll(new ExtensionFilter("PDF Files", "*.pdf"));

        selectedFile = fc.showOpenDialog(null);
        if (selectedFile != null) {
            data.setText(selectedFile.getAbsolutePath());
        } else {
            System.out.println("file is not valid");
        }
    }

    public void pengajuanproposal(ActionEvent actionevent) throws IOException {
        String to = emailto.getText();
        String from = emailfrom.getText();
        String host = "smtp.gmail.com";
        final String Username = emailfrom.getText();
        final String Password = password.getText();


        Properties props = System.getProperties();

        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "587");

        Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(Username, Password);
            }
        });

        try {
            MimeMessage m = new MimeMessage(session);
            m.setFrom(new InternetAddress(from));
            m.addRecipient(MimeMessage.RecipientType.TO, new InternetAddress(to));
            m.setSubject(subject.getText());
            m.setText(message.getText());
            
            Transport.send(m);
            System.out.println("Terkirim");
        } catch(MessagingException e) {
            e.printStackTrace();
        }
        
        Parent root = FXMLLoader.load(getClass().getResource("FXMLdikirim.fxml"));
        stage = (Stage) ((Node) actionevent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    public void draflaporan(ActionEvent actionevent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLdraftlaporanPKNdosen.fxml"));
        stage = (Stage) ((Node) actionevent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void back(ActionEvent actionevent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLdashdosen.fxml"));
        stage = (Stage) ((Node) actionevent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
