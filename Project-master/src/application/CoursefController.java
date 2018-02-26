package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
/**
 *<p> Manages the courses of the Faculty </p>
 * @author anush
 *
 */
public class CoursefController {

    
    @FXML
    Button back;
   
    @FXML
    private void homepage1(ActionEvent event) throws IOException{
        Stage stage = null; 
        Parent root = null; 
        stage=(Stage) back.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("Faculty.fxml"));
        Scene scene = new Scene(root);
	    scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

        stage.setScene(scene);
        stage.show();
       }
   
}

