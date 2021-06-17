/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import conecctor.databasemahasiswa;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import static javax.swing.UIManager.getString;

/**
 *
 * @author USER
 */
public class loginControllermahasiswa {

    private Stage stage;
    private Scene scene;
    private Parent root;

    public ObservableList<setgetdata> getDataList() throws SQLException {
        ObservableList<setgetdata> dataList = FXCollections.observableArrayList();
        databasemahasiswa dbmahasiswa = new databasemahasiswa();
        Connection connection = databasemahasiswa.getConnection();
        String query = "SELECT * FROM user";
        Statement st;
        ResultSet rs;

        try {
            st = connection.createStatement();
            rs = st.executeQuery(query);
            setgetdata data;
            while (rs.next()) {
                data = new setgetdata(rs.getString("Username"), rs.getString("Password"));
                dataList.add(data);
            }
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
        return dataList;
    }

    public TextField username;
    public TextField password;

    public void login(ActionEvent actionevent) throws IOException, SQLException {
        ObservableList<setgetdata> list = getDataList();
       
        if (username.equals(getString("Username")) ) {
            Parent root = FXMLLoader.load(getClass().getResource("FXMLlogin.fxml"));
            stage = (Stage) ((Node) actionevent.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }else {
            Parent root = FXMLLoader.load(getClass().getResource("FXMLloginmahasiswa.fxml"));
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
