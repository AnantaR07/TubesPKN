/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainclass;

import conecctor.databaseuploadmahasiswa;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author USER
 */
public class dashControllerpengumuman {

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
    public TextField pencarian_nama; 
    public Label pengumuman;

    private Stage stage;
    private Scene scene;
    private Parent root;
    
    setgetpesan pesan = new setgetpesan();

   public void refresh(ActionEvent actionevent) throws SQLException {
            pengumuman.setText(pesan.toString());
       
            databaseuploadmahasiswa connect = new databaseuploadmahasiswa();
            Connection conn = databaseuploadmahasiswa.getConnection();
            String query = "select * from user where Nama3 = '"+pencarian_nama.getText()+"' ";
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
            System.out.println("Nama tidak ada");
        }
    }
   
   public void upload(ActionEvent actionevent) throws SQLException, IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLdikirim.fxml"));
        stage = (Stage) ((Node) actionevent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
   }
   
    public void email(ActionEvent actionevent) throws SQLException, IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLdashmahasiswaa.fxml"));
        stage = (Stage) ((Node) actionevent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
   }
    
    public void back(ActionEvent actionevent) throws SQLException, IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLdashmahasiswaa.fxml"));
        stage = (Stage) ((Node) actionevent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
   }

}
