package application;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.stage.Stage;


/**
 * <p> Admin Controller handles the Admin redirection to its Profile ,view requests and view Rooms</p>
 * @author anush
 *
 */
public class AdminController {
	Member mem;
	@FXML
	Button name;
	@FXML
	Button emailid;
	@FXML
	Button myprof;
	@FXML
	Button viewreq;
	@FXML
	Button bookr;
	@FXML
	Button logout;
	@FXML
	AnchorPane Pane4;

	@FXML
	private void viewreqClick(ActionEvent event) throws IOException{
		
		
		
        Stage stage = null; 
        Parent root = null; 
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Requests.fxml"));
        stage=(Stage) viewreq.getScene().getWindow();
        root = (Parent)fxmlLoader.load();
        RequestAdminController controller = fxmlLoader.<RequestAdminController>getController();
        controller.mem=mem;
        Scene scene = new Scene(root);
	    scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

        stage.setScene(scene);
        stage.show();

		
		
		
		
		
		
		
	}
	@FXML
	private void bookrClick(ActionEvent event) throws IOException{
		Stage stage = null; 
		Parent root = null; 
		stage=(Stage) bookr.getScene().getWindow();
		root = FXMLLoader.load(getClass().getResource("View_Rooms.fxml"));
		Scene scene = new Scene(root);
	    scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

		stage.setScene(scene);
		stage.show();
	}
	@FXML
	private void logoutClick(ActionEvent event) throws IOException{
        Stage stage = null; 
        Parent root = null; 
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("HomePage.fxml"));
        stage=(Stage) logout.getScene().getWindow();
        root = (Parent)fxmlLoader.load();
        HomePageController controller = fxmlLoader.<HomePageController>getController();
        controller.college=mem.thisCollege;
        mem.thisCollege.serialize();

        Scene scene = new Scene(root); scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}


