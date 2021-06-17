/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import biodatapkn.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 *
 * @author USER
 */
public class loginControllerdosen{
    private Stage stage;
    private Scene scene;
    private Parent root;
    
     public void back(ActionEvent actionevent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLlogin.fxml"));
        stage = (Stage) ((Node) actionevent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
}
