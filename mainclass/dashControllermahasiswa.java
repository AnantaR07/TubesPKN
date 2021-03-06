/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainclass;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;

/**
 *
 * @author USER
 */
public class dashControllermahasiswa {

    @FXML
    private RadioButton fxmahasiswa, fxdosen, fxtu;
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void pengajuanproposal(ActionEvent actionevent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLdashuploadmahasiswa.fxml"));
        stage = (Stage) ((Node) actionevent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void pengumumanpengajuanproposal(ActionEvent actionevent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLdashpengumuman.fxml"));
        stage = (Stage) ((Node) actionevent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void pengajuanberkas(ActionEvent actionevent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLdashpengajuanberkas.fxml"));
        stage = (Stage) ((Node) actionevent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void draftlaporanpkn(ActionEvent actionevent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLdraftlaporanPKN.fxml"));
        stage = (Stage) ((Node) actionevent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void draftlaporanpknadmin(ActionEvent actionevent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLuploaddenganformat.fxml"));
        stage = (Stage) ((Node) actionevent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void logout(ActionEvent actionevent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLlogin.fxml"));
        stage = (Stage) ((Node) actionevent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void pendaftaranujian(ActionEvent actionevent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLberkasPKN.fxml"));
        stage = (Stage) ((Node) actionevent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

}
