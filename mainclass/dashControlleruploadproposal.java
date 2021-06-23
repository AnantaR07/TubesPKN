/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainclass;

import java.io.File;
import java.io.IOException;
import static java.nio.file.Files.list;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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
    
    private Stage stage;
    private Scene scene;
    private Parent root;

public void filepenyimpanan(ActionEvent actionevent) throws IOException {
    FileChooser fc = new FileChooser();
            fc.setInitialDirectory(new File("C:\\"));
            fc.getExtensionFilters().addAll(new ExtensionFilter("PDF Files", "*.pdf"));

            File selectedFile = fc.showOpenDialog(null);
            if(selectedFile != null){
                table.getItems().add(selectedFile.getAbsolutePath());
            }
            else{
                System.out.println("file is not valid");
            }
}
    
    public void pengajuanproposal(ActionEvent actionevent) throws IOException {
        
    }

    public void back(ActionEvent actionevent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLdashmahasiswa.fxml"));
        stage = (Stage) ((Node) actionevent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
