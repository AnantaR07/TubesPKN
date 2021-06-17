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
public class loginControllerlogin {

    @FXML
    private RadioButton fxmahasiswa, fxdosen, fxtu;
    private Stage stage;
    private Scene scene;
    private Parent root;


    public void select(ActionEvent actionevent) throws IOException {
        if (fxmahasiswa.isSelected()) {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLloginmahasiswa.fxml"));
        stage = (Stage) ((Node) actionevent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        } else if (fxdosen.isSelected()) {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLlogindosen.fxml"));
        stage = (Stage) ((Node) actionevent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        } else if (fxtu.isSelected()) {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLlogintu.fxml"));
        stage = (Stage) ((Node) actionevent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        }
    }

}
