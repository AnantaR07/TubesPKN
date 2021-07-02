/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainclass;

import conecctor.databaseuploadmahasiswa;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author USER
 */
public class dashControlleruploadmahasiswa {

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

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void uploadportofolio(ActionEvent actionevent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLuploadproposal.fxml"));
        stage = (Stage) ((Node) actionevent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void upload(ActionEvent actionevent) throws IOException, SQLException {
        databaseuploadmahasiswa connect = new databaseuploadmahasiswa();
        Connection connection = databaseuploadmahasiswa.getConnection();

        String sql1 = "INSERT INTO USER VALUES('" + nim1.getText() + "','" + nama1.getText() + "','" + nim2.getText() + "','" + nama2.getText() + "','" + nim3.getText() + "','" + nama3.getText() + "','" + nim4.getText() + "','" + nama4.getText() + "','" + programstudi.getText() + "','" + judul.getText() + "','" + tempatpkn.getText() + "','" + waktupelaksanaan.getText() + "','" + dosenpembimbing.getText() + "')";

        Statement statement = connection.createStatement();
        statement.executeUpdate(sql1);

        Parent root = FXMLLoader.load(getClass().getResource("FXMLdikirim2.fxml"));
        stage = (Stage) ((Node) actionevent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void back(ActionEvent actionevent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLdashmahasiswaa.fxml"));
        stage = (Stage) ((Node) actionevent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
