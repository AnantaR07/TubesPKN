/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainclass;

import conecctor.databaseadmin;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author USER
 */
public class loginControlleradmin{
    
    private Stage stage;
    private Scene scene;
    private Parent root;
    
    public TextField username;
    public PasswordField password;

    public void login(ActionEvent actionevent) throws IOException, SQLException {
        databaseadmin dbadmin = new databaseadmin();
        Connection connection = databaseadmin.getConnection();
        String query = "SELECT * FROM user where Username=? and Password=?";
        PreparedStatement pst = connection.prepareStatement(query);
        pst.setString(1, username.getText());
        pst.setString(2, password.getText());
        ResultSet rs = pst.executeQuery();
        
        if(rs.next()){
            Parent root = FXMLLoader.load(getClass().getResource("FXMLdashadmin.fxml"));
            stage = (Stage) ((Node) actionevent.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }else {
            username.setText("");
            password.setText("");
            JOptionPane.showMessageDialog(null, "username dan Password salah");
            Parent root = FXMLLoader.load(getClass().getResource("FXMLloginadmin.fxml"));
            stage = (Stage) ((Node) actionevent.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }
    
     public void back(ActionEvent actionevent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLlogin.fxml"));
        stage = (Stage) ((Node) actionevent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }  
    
}
