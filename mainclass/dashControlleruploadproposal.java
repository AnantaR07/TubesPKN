/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainclass;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

/**
 *
 * @author USER
 */
public class dashControlleruploadproposal {

    @FXML
    private TableView table;
    
    public TextField email;
    
    private Stage stage;
    private Scene scene;
    private Parent root;
    
    File selectedFile;

public void filepenyimpanan(ActionEvent actionevent) throws IOException,FileNotFoundException {
    FileChooser fc = new FileChooser();
            fc.setInitialDirectory(new File("C:\\"));
            fc.getExtensionFilters().addAll(new ExtensionFilter("PDF Files", "*.pdf"));

            selectedFile = fc.showOpenDialog(null);
            if(selectedFile != null){
                table.getItems().add(selectedFile.getAbsolutePath());
            }
            else{
                System.out.println("file is not valid");
            }
            
            
            
}
    
    public void pengajuanproposal(ActionEvent actionevent) throws IOException {
        dashControlleruploadproposal upload = new dashControlleruploadproposal();
        try{
                FileWriter fileOutput= new FileWriter("C:\\Users\\USER\\Documents\\tubesPBOPKN\\src\\upload", true);
                BufferedWriter bufferOutput = new BufferedWriter(fileOutput);
                bufferOutput.write(upload.selectedFile.getAbsolutePath());
                bufferOutput.newLine();
                bufferOutput.flush();
                bufferOutput.close();
            }catch (Exception e){
                
            }
    }

    public void back(ActionEvent actionevent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLdashmahasiswa.fxml"));
        stage = (Stage) ((Node) actionevent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
