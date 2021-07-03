/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainclass;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
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
public class dashControllerdraftlaporanPKN {

    public TextField emailto;
    public TextField emailfrom;
    public PasswordField password;
    public TextField subject;
    public TextArea message;
    
    public Label data;

    private Stage stage;
    private Scene scene;
    private Parent root;
    
    File selectedFile;

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
        
        Parent root = FXMLLoader.load(getClass().getResource("FXMLdikirim4.fxml"));
        stage = (Stage) ((Node) actionevent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void uploadsuratpengantar(ActionEvent actionevent) throws IOException, FileNotFoundException {
        FileChooser fc = new FileChooser();
        fc.setInitialDirectory(new File("C:\\"));
        fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("PDF Files", "*.pdf"));

        selectedFile = fc.showOpenDialog(null);
        if (selectedFile != null) {
            data.setText(selectedFile.getAbsolutePath());
        } else {
            System.out.println("file is not valid");
        }
    }
    
    public void back(ActionEvent actionevent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLdashmahasiswaa.fxml"));
        stage = (Stage) ((Node) actionevent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
