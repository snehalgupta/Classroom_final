package application;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Map.Entry;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTimePicker;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
/**
 * 
 * <p> This is View_RoomsfController  associated with the ViewRoomfForm.fxml </p>
 *  <p> It as the name suggest openes a theatre like room viewing system for a faculty</p>
 * <p>For a given time slot all the room buttons change its colors based on their availablity </p>
 * @author Anushka Bhandari
 * @author Snehal Gupta
 * @version 1.0
 * @since November 11, 2017
 *
 *
 *
 *
 *
 */
public class View_RoomsfController {
	Member mem;
	//Faculty stu;
	@FXML
	JFXTimePicker start;

	@FXML
	JFXTimePicker end;

	@FXML
	JFXDatePicker date;

	@FXML
	Button back;
	@FXML
	Button btn1;
	@FXML
	Button btn2;
	@FXML
	Button btn3;
	@FXML
	Button btn4;
	@FXML
	Button btn5;
	@FXML
	Button btn6;
	@FXML
	Button btn7;
	@FXML
	Button btn8;
	@FXML
	Button btn0;
	@FXML
	Button btn10;
	@FXML
	Button btn11;
	@FXML
	Button btn12;
	@FXML
	Button btn13;
	@FXML
	Button btn14;
	@FXML
	Button btn15;
	@FXML
	Button btn16;
	@FXML
	Button btn17;
	@FXML
	Button btn18;
	@FXML
	Button btn19;
	@FXML
	Button btn20;
	@FXML
	Button btn21;
	@FXML
	Button btn123;
	@FXML
	Button gob;
	@FXML
	Button C24;
	@FXML
	AnchorPane Pane6;
	@FXML
	private void C24click(ActionEvent event) throws IOException{
		Stage stage ; 
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Room_Formf.fxml"));     
		stage=(Stage) C24.getScene().getWindow();
		Parent root = (Parent)fxmlLoader.load();          
		Room_FormfController controller = fxmlLoader.<Room_FormfController>getController();
		controller.label.setText(C24.getText());
		controller.start.setText(start.getValue().toString());controller.roomCap.setText(Integer.toString(mem.thisCollege.getRoom(C24.getText()).Capacity));
		controller.end.setText(end.getValue().toString());
		controller.start.setEditable(false);
		controller.end.setEditable(false);
		controller.mem=mem;
		controller.date.setText(date.getValue().toString());
		controller.date.setEditable(false);
		Scene scene = new Scene(root); scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm()); 
		stage.setScene(scene);    
		stage.show();   
	}

	@FXML

	private void viewroom123Click(ActionEvent event) throws IOException{


		Stage stage ; 
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Room_Formf.fxml"));
		stage=(Stage) btn123.getScene().getWindow();
		Parent root = (Parent)fxmlLoader.load();          
		Room_FormfController controller = fxmlLoader.<Room_FormfController>getController();

		controller.label.setText(btn123.getText());
		controller.mem=mem;
		controller.start.setText(start.getValue().toString());controller.roomCap.setText(Integer.toString(mem.thisCollege.getRoom(btn123.getText()).Capacity));

		controller.end.setText(end.getValue().toString());
		controller.start.setEditable(false);
		controller.end.setEditable(false);

		controller.date.setText(date.getValue().toString());
		controller.date.setEditable(false);
		Scene scene = new Scene(root); scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm()); scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm()); 
		stage.setScene(scene);    
		stage.show();
	}


	@FXML
	private void viewroomClick(ActionEvent event) throws IOException{
		Stage stage ; 
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Room_Formf.fxml"));     
		stage=(Stage) btn1.getScene().getWindow();
		Parent root = (Parent)fxmlLoader.load();          
		Room_FormfController controller = fxmlLoader.<Room_FormfController>getController();
		controller.label.setText(btn1.getText());
		controller.mem=mem;
		controller.start.setText(start.getValue().toString());controller.roomCap.setText(Integer.toString(mem.thisCollege.getRoom(btn1.getText()).Capacity));
		controller.end.setText(end.getValue().toString());
		controller.start.setEditable(false);
		controller.end.setEditable(false);
		controller.date.setText(date.getValue().toString());
		controller.date.setEditable(false);
		Scene scene = new Scene(root); scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm()); scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm()); scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm()); 
		stage.setScene(scene);    
		stage.show();
	}
	@FXML
	private void viewroom2Click(ActionEvent event) throws IOException{
		Stage stage ; 
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Room_Formf.fxml"));     
		stage=(Stage) btn2.getScene().getWindow();
		Parent root = (Parent)fxmlLoader.load();          
		Room_FormfController controller = fxmlLoader.<Room_FormfController>getController();
		controller.label.setText(btn2.getText());
		controller.mem=mem;
		controller.start.setText(start.getValue().toString());controller.roomCap.setText(Integer.toString(mem.thisCollege.getRoom(btn2.getText()).Capacity));
		controller.end.setText(end.getValue().toString());
		controller.start.setEditable(false);
		controller.end.setEditable(false);
		controller.date.setText(date.getValue().toString());
		controller.date.setEditable(false);
		Scene scene = new Scene(root); scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm()); scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm()); 
		stage.setScene(scene);    
		stage.show();
	}
	@FXML
	private void viewroom3Click(ActionEvent event) throws IOException{
		Stage stage ; 
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Room_Formf.fxml"));     
		stage=(Stage) btn3.getScene().getWindow();
		Parent root = (Parent)fxmlLoader.load();          
		Room_FormfController controller = fxmlLoader.<Room_FormfController>getController();
		controller.label.setText(btn3.getText());
		controller.mem=mem;
		controller.start.setText(start.getValue().toString());controller.roomCap.setText(Integer.toString(mem.thisCollege.getRoom(btn3.getText()).Capacity));
		controller.end.setText(end.getValue().toString());
		controller.start.setEditable(false);
		controller.end.setEditable(false);
		controller.date.setText(date.getValue().toString());
		controller.date.setEditable(false);
		Scene scene = new Scene(root); scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm()); scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm()); 
		stage.setScene(scene);    
		stage.show();
	}
	@FXML
	private void viewroom4Click(ActionEvent event) throws IOException{
		Stage stage ; 
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Room_Formf.fxml"));     
		stage=(Stage) btn4.getScene().getWindow();
		Parent root = (Parent)fxmlLoader.load();          
		Room_FormfController controller = fxmlLoader.<Room_FormfController>getController();
		controller.label.setText(btn4.getText());
		controller.start.setText(start.getValue().toString());controller.roomCap.setText(Integer.toString(mem.thisCollege.getRoom(btn4.getText()).Capacity));
		controller.mem=mem;
		controller.end.setText(end.getValue().toString());
		controller.start.setEditable(false);
		controller.end.setEditable(false);
		controller.date.setText(date.getValue().toString());
		controller.date.setEditable(false);
		Scene scene = new Scene(root); scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm()); scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm()); 
		stage.setScene(scene);    
		stage.show();
	}
	@FXML
	private void viewroom5Click(ActionEvent event) throws IOException{
		Stage stage ; 
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Room_Formf.fxml"));     
		stage=(Stage) btn5.getScene().getWindow();
		Parent root = (Parent)fxmlLoader.load();          
		Room_FormfController controller = fxmlLoader.<Room_FormfController>getController();
		controller.start.setText(start.getValue().toString());controller.roomCap.setText(Integer.toString(mem.thisCollege.getRoom(btn5.getText()).Capacity));
		controller.end.setText(end.getValue().toString());
		controller.label.setText(btn5.getText());
		controller.mem=mem;
		controller.start.setEditable(false);
		controller.end.setEditable(false);
		controller.date.setText(date.getValue().toString());
		controller.date.setEditable(false);
		Scene scene = new Scene(root); scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm()); scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm()); 
		stage.setScene(scene);    
		stage.show();
	}
	@FXML
	private void viewroom6Click(ActionEvent event) throws IOException{
		Stage stage ; 
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Room_Formf.fxml"));     
		stage=(Stage) btn6.getScene().getWindow();
		Parent root = (Parent)fxmlLoader.load();          
		Room_FormfController controller = fxmlLoader.<Room_FormfController>getController();
		controller.start.setText(start.getValue().toString());controller.roomCap.setText(Integer.toString(mem.thisCollege.getRoom(btn6.getText()).Capacity));
		controller.end.setText(end.getValue().toString());
		controller.label.setText(btn6.getText());
		controller.mem=mem;
		controller.start.setEditable(false);
		controller.end.setEditable(false);
		controller.date.setText(date.getValue().toString());
		controller.date.setEditable(false);
		Scene scene = new Scene(root); scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm()); scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm()); 
		stage.setScene(scene);    
		stage.show();
	}
	@FXML
	private void viewroom7Click(ActionEvent event) throws IOException{
		Stage stage ; 
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Room_Formf.fxml"));     
		stage=(Stage) btn7.getScene().getWindow();
		Parent root = (Parent)fxmlLoader.load();          
		Room_FormfController controller = fxmlLoader.<Room_FormfController>getController();
		controller.start.setText(start.getValue().toString());controller.roomCap.setText(Integer.toString(mem.thisCollege.getRoom(btn7.getText()).Capacity));
		controller.end.setText(end.getValue().toString());
		controller.label.setText(btn7.getText());
		controller.start.setEditable(false);
		controller.mem=mem;
		controller.end.setEditable(false);
		controller.date.setText(date.getValue().toString());
		controller.date.setEditable(false);
		Scene scene = new Scene(root); scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm()); scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm()); 
		stage.setScene(scene);    
		stage.show();
	}
	@FXML
	private void viewroom8Click(ActionEvent event) throws IOException{
		Stage stage ; 
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Room_Formf.fxml"));     
		stage=(Stage) btn8.getScene().getWindow();
		Parent root = (Parent)fxmlLoader.load();          
		Room_FormfController controller = fxmlLoader.<Room_FormfController>getController();
		controller.start.setText(start.getValue().toString());controller.roomCap.setText(Integer.toString(mem.thisCollege.getRoom(btn8.getText()).Capacity));
		controller.end.setText(end.getValue().toString());
		controller.label.setText(btn8.getText());
		controller.mem=mem;
		controller.start.setEditable(false);
		controller.end.setEditable(false);
		controller.date.setText(date.getValue().toString());
		controller.date.setEditable(false);
		Scene scene = new Scene(root); scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm()); scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm()); 
		stage.setScene(scene);    
		stage.show();
	}
	@FXML
	private void viewroom9Click(ActionEvent event) throws IOException{
		Stage stage ; 
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Room_Formf.fxml"));     
		stage=(Stage) btn0.getScene().getWindow();
		Parent root = (Parent)fxmlLoader.load();          
		Room_FormfController controller = fxmlLoader.<Room_FormfController>getController();
		controller.start.setText(start.getValue().toString());controller.roomCap.setText(Integer.toString(mem.thisCollege.getRoom(btn0.getText()).Capacity));
		controller.end.setText(end.getValue().toString());
		controller.mem=mem;
		controller.label.setText(btn0.getText());
		controller.start.setEditable(false);
		controller.end.setEditable(false);
		controller.date.setText(date.getValue().toString());
		controller.date.setEditable(false);
		Scene scene = new Scene(root); scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm()); scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm()); 
		stage.setScene(scene);    
		stage.show();
	}
	@FXML
	private void viewroom10Click(ActionEvent event) throws IOException{
		Stage stage ; 
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Room_Formf.fxml"));     
		stage=(Stage) btn10.getScene().getWindow();
		Parent root = (Parent)fxmlLoader.load();          
		Room_FormfController controller = fxmlLoader.<Room_FormfController>getController();
		controller.label.setText(btn10.getText());
		controller.mem=mem;
		controller.start.setText(start.getValue().toString());controller.roomCap.setText(Integer.toString(mem.thisCollege.getRoom(btn10.getText()).Capacity));
		controller.end.setText(end.getValue().toString());
		controller.start.setEditable(false);
		controller.end.setEditable(false);
		controller.date.setText(date.getValue().toString());
		controller.date.setEditable(false);
		Scene scene = new Scene(root); scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm()); scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm()); 
		stage.setScene(scene);    
		stage.show();
	}
	@FXML
	private void viewroom11Click(ActionEvent event) throws IOException{
		Stage stage ; 
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Room_Formf.fxml"));     
		stage=(Stage) btn11.getScene().getWindow();
		Parent root = (Parent)fxmlLoader.load();          
		Room_FormfController controller = fxmlLoader.<Room_FormfController>getController();
		controller.label.setText(btn11.getText());
		controller.mem=mem;
		controller.start.setText(start.getValue().toString());controller.roomCap.setText(Integer.toString(mem.thisCollege.getRoom(btn11.getText()).Capacity));
		controller.end.setText(end.getValue().toString());
		controller.start.setEditable(false);
		controller.end.setEditable(false);
		controller.date.setText(date.getValue().toString());
		controller.date.setEditable(false);
		Scene scene = new Scene(root); scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm()); scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm()); 
		stage.setScene(scene);    
		stage.show();
	}
	@FXML
	private void viewroom12Click(ActionEvent event) throws IOException{
		Stage stage ; 
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Room_Formf.fxml"));     
		stage=(Stage) btn12.getScene().getWindow();
		Parent root = (Parent)fxmlLoader.load();          
		Room_FormfController controller = fxmlLoader.<Room_FormfController>getController();
		controller.label.setText(btn12.getText());
		controller.mem=mem;
		controller.start.setText(start.getValue().toString());controller.roomCap.setText(Integer.toString(mem.thisCollege.getRoom(btn12.getText()).Capacity));
		controller.end.setText(end.getValue().toString());
		controller.start.setEditable(false);
		controller.end.setEditable(false);
		controller.date.setText(date.getValue().toString());
		controller.date.setEditable(false);
		Scene scene = new Scene(root); scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm()); scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm()); 
		stage.setScene(scene);    
		stage.show();
	}
	@FXML
	private void viewroom13Click(ActionEvent event) throws IOException{
		Stage stage ; 
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Room_Formf.fxml"));     
		stage=(Stage) btn13.getScene().getWindow();
		Parent root = (Parent)fxmlLoader.load();          
		Room_FormfController controller = fxmlLoader.<Room_FormfController>getController();
		controller.label.setText(btn13.getText());
		controller.mem=mem;
		controller.start.setText(start.getValue().toString());controller.roomCap.setText(Integer.toString(mem.thisCollege.getRoom(btn13.getText()).Capacity));
		controller.end.setText(end.getValue().toString());
		controller.start.setEditable(false);
		controller.end.setEditable(false);
		controller.date.setText(date.getValue().toString());
		controller.date.setEditable(false);
		Scene scene = new Scene(root); scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm()); scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm()); 
		stage.setScene(scene);    
		stage.show();
	}
	@FXML
	private void viewroom14Click(ActionEvent event) throws IOException{
		Stage stage ; 
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Room_Formf.fxml"));     
		stage=(Stage) btn14.getScene().getWindow();
		Parent root = (Parent)fxmlLoader.load();          
		Room_FormfController controller = fxmlLoader.<Room_FormfController>getController();
		controller.label.setText(btn14.getText());
		controller.start.setText(start.getValue().toString());controller.roomCap.setText(Integer.toString(mem.thisCollege.getRoom(btn14.getText()).Capacity));
		controller.mem=mem;
		controller.end.setText(end.getValue().toString());
		controller.start.setEditable(false);
		controller.end.setEditable(false);
		controller.date.setText(date.getValue().toString());
		controller.date.setEditable(false);
		Scene scene = new Scene(root); scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm()); scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm()); 
		stage.setScene(scene);    
		stage.show();
	}
	@FXML
	private void viewroom15Click(ActionEvent event) throws IOException{
		Stage stage ; 
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Room_Formf.fxml"));     
		stage=(Stage) btn15.getScene().getWindow();
		Parent root = (Parent)fxmlLoader.load();          
		Room_FormfController controller = fxmlLoader.<Room_FormfController>getController();
		controller.label.setText(btn15.getText());
		controller.mem=mem;
		controller.start.setText(start.getValue().toString());controller.roomCap.setText(Integer.toString(mem.thisCollege.getRoom(btn15.getText()).Capacity));
		controller.end.setText(end.getValue().toString());
		controller.start.setEditable(false);
		controller.end.setEditable(false);
		controller.date.setText(date.getValue().toString());
		controller.date.setEditable(false);
		Scene scene = new Scene(root); scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm()); scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm()); 
		stage.setScene(scene);    
		stage.show();
	}
	@FXML
	private void viewroom16Click(ActionEvent event) throws IOException{
		Stage stage ; 
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Room_Formf.fxml"));     
		stage=(Stage) btn16.getScene().getWindow();
		Parent root = (Parent)fxmlLoader.load();   
		
		Room_FormfController controller = fxmlLoader.<Room_FormfController>getController();
		controller.label.setText(btn16.getText());
		controller.start.setText(start.getValue().toString());controller.roomCap.setText(Integer.toString(mem.thisCollege.getRoom(btn16.getText()).Capacity));
		controller.mem=mem;
		controller.end.setText(end.getValue().toString());
		controller.start.setEditable(false);
		controller.end.setEditable(false);
		controller.date.setText(date.getValue().toString());
		controller.date.setEditable(false);
		Scene scene = new Scene(root); scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm()); scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm()); 
		stage.setScene(scene);    
		stage.show();
	}
	@FXML
	private void viewroom17Click(ActionEvent event) throws IOException{
		Stage stage ; 
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Room_Formf.fxml"));     
		stage=(Stage) btn17.getScene().getWindow();
		Parent root = (Parent)fxmlLoader.load();          
		Room_FormfController controller = fxmlLoader.<Room_FormfController>getController();
		controller.label.setText(btn17.getText());
		controller.start.setText(start.getValue().toString());controller.roomCap.setText(Integer.toString(mem.thisCollege.getRoom(btn17.getText()).Capacity));
		controller.end.setText(end.getValue().toString());
		controller.start.setEditable(false);
		controller.end.setEditable(false);
		controller.mem=mem;
		controller.date.setText(date.getValue().toString());
		controller.date.setEditable(false);
		Scene scene = new Scene(root); scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm()); scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm()); 
		stage.setScene(scene);    
		stage.show();
	}
	@FXML
	private void viewroom18Click(ActionEvent event) throws IOException{
		Stage stage ; 
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Room_Formf.fxml"));     
		stage=(Stage) btn18.getScene().getWindow();
		Parent root = (Parent)fxmlLoader.load();          
		Room_FormfController controller = fxmlLoader.<Room_FormfController>getController();
		controller.label.setText(btn18.getText());
		controller.start.setText(start.getValue().toString());controller.roomCap.setText(Integer.toString(mem.thisCollege.getRoom(btn18.getText()).Capacity));
		controller.end.setText(end.getValue().toString());
		controller.start.setEditable(false);
		controller.end.setEditable(false);
		controller.mem=mem;
		controller.date.setText(date.getValue().toString());
		controller.date.setEditable(false);
		Scene scene = new Scene(root); scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm()); scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm()); 
		stage.setScene(scene);    
		stage.show();
	}
	@FXML
	private void viewroom19Click(ActionEvent event) throws IOException{
		Stage stage ; 
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Room_Formf.fxml"));     
		stage=(Stage) btn19.getScene().getWindow();
		Parent root = (Parent)fxmlLoader.load();          
		Room_FormfController controller = fxmlLoader.<Room_FormfController>getController();
		controller.label.setText(btn19.getText());
		controller.start.setText(start.getValue().toString());controller.roomCap.setText(Integer.toString(mem.thisCollege.getRoom(btn19.getText()).Capacity));
		controller.end.setText(end.getValue().toString());
		controller.start.setEditable(false);
		controller.end.setEditable(false);
		controller.mem=mem;
		controller.date.setText(date.getValue().toString());
		controller.date.setEditable(false);
		Scene scene = new Scene(root); scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm()); scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm()); 
		stage.setScene(scene);    
		stage.show();
	}
	@FXML
	private void viewroom20Click(ActionEvent event) throws IOException{
		Stage stage ; 
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Room_Formf.fxml"));     
		stage=(Stage) btn20.getScene().getWindow();
		Parent root = (Parent)fxmlLoader.load();          
		Room_FormfController controller = fxmlLoader.<Room_FormfController>getController();
		controller.label.setText(btn20.getText());
		controller.start.setText(start.getValue().toString());controller.roomCap.setText(Integer.toString(mem.thisCollege.getRoom(btn20.getText()).Capacity));
		controller.end.setText(end.getValue().toString());
		controller.start.setEditable(false);
		controller.end.setEditable(false);
		controller.mem=mem;
		controller.date.setText(date.getValue().toString());
		controller.date.setEditable(false);
		Scene scene = new Scene(root); scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm()); scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm()); 
		stage.setScene(scene);    
		stage.show();
	}
	@FXML
	private void viewroom21Click(ActionEvent event) throws IOException{
		Stage stage ; 
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Room_Formf.fxml"));     
		stage=(Stage) btn21.getScene().getWindow();
		Parent root = (Parent)fxmlLoader.load();          
		Room_FormfController controller = fxmlLoader.<Room_FormfController>getController();
		controller.label.setText(btn21.getText());
		controller.start.setText(start.getValue().toString());controller.roomCap.setText(Integer.toString(mem.thisCollege.getRoom(btn21.getText()).Capacity));
		controller.end.setText(end.getValue().toString());
		controller.start.setEditable(false);
		controller.end.setEditable(false);
		controller.mem=mem;
		controller.date.setText(date.getValue().toString());
		controller.date.setEditable(false);
		Scene scene = new Scene(root); scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm()); scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm()); 
		stage.setScene(scene);    
		stage.show();   
	}
	@FXML
	private void backClick(ActionEvent event) throws IOException{
        Stage stage = null; 
        Parent root = null; 
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Faculty.fxml"));
        stage=(Stage) back.getScene().getWindow();
        root = (Parent)fxmlLoader.load();
       FacultyController controller = fxmlLoader.<FacultyController>getController();
        controller.mem=mem;
        controller.name.setText(mem.Name);
        controller.emailid.setText(mem.email);

//        System.out.println(controller.mem.Name+" hogaya hoga");
        Scene scene = new Scene(root); scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm()); scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stage.setScene(scene);
        stage.show();

        
	}
	@FXML
	private void goClick(ActionEvent event) throws IOException{

		String datevar=date.getValue().toString();
		String st=start.getValue().toString();
		String ed=end.getValue().toString();

		String n="";
		for(int we=0;we<st.length();we++){
			if(st.charAt(we) != ':'){
				n+=st.charAt(we);
			}
		}
		n+='-';
		for(int rt=0;rt<st.length();rt++){
			if(ed.charAt(rt) != ':'){
				n+=ed.charAt(rt);
			}
		}
		//System.out.println(n);
		LocalDate localDate = date.getValue();

		Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
		int date = Date.from(instant).getDay();
		//String dh=datevar.toString();
		System.out.println(date);
		String day="";
		if(date == 1){
			day="Mon";
		}
		else if(date == 2){
			day="Tue";
		}
		else if(date == 3){
			day="Wed";
		}
		else if(date == 4){
			day="Thu";
		}
		else if(date == 5){
			day="Fri";
		}
		else if(date == 0){
			day="Sun";
		}
		else if(date == 6){
			day="Sat";
		}
		System.out.println(datevar+" "+n+" "+day);




		// day- day , n-timeslot , datevar-date
		//String cv="";

		HashMap<Room,Boolean> b=Room.okay(n,day,datevar, mem.thisCollege);
		//   for(Entry<Room,Boolean> h:b.entrySet()) {
		//	   if(h.getValue()==true){
		//		  String fg=h.getKey().Room_number;
		//		  if(fg.equals("C01")){
		//			  btn5.
		//		  }
		//}
		for(Entry<Room,Boolean> r:b.entrySet())
		{
			System.out.println(r.getValue()+" "+r.getKey().toString());
		}
		Room r=Room.getInstance("C01", mem.thisCollege);
		Boolean fal=b.get(r);
		System.out.println(r);
		if(fal.equals(true))
		{btn5.setStyle("-fx-background-color: #aa8cc5; ");
		btn5.setDisable(false);
	}
		else{
			btn5.setStyle("-fx-background-color: #FF5252; ");

			btn5.setDisable(true);
		}


		//		r=Room.getInstance("C02", mem.thisCollege);
		r=mem.thisCollege.getRoom("C02");
		fal=b.get(r); System.out.println(r);
		if(fal.equals(true))
		{btn0.setStyle("-fx-background-color: #aa8cc5; ");
		btn0.setDisable(false);
	}
		else{
			btn0.setStyle("-fx-background-color: #FF5252; ");

			btn0.setDisable(true);
		}

		//r=Room.getInstance("C03", mem.thisCollege);
		r=mem.thisCollege.getRoom("C03");

		fal=b.get(r); System.out.println(r);
		if(fal.equals(true))
		{btn2.setStyle("-fx-background-color: #aa8cc5; ");
		btn2.setDisable(false);
}
		else{
			btn2.setStyle("-fx-background-color: #FF5252; ");

			btn2.setDisable(true);
		}

		//r=Room.getInstance("C11", mem.thisCollege);
		r=mem.thisCollege.getRoom("C11");

		System.out.println(r);

		fal=b.get(r); System.out.println(r);
		if(fal.equals(true))
		{btn4.setStyle("-fx-background-color: #aa8cc5; ");
		btn4.setDisable(false);
	}
		else{
			btn4.setStyle("-fx-background-color: #FF5252; ");

			btn4.setDisable(true);
		}

		r=mem.thisCollege.getRoom("C12");
		System.out.println(r);

		fal=b.get(r); System.out.println(r);
		if(fal.equals(true))
		{btn6.setStyle("-fx-background-color: #aa8cc5; ");
		btn6.setDisable(false);
	}
		else{
			btn6.setStyle("-fx-background-color: #FF5252; ");

			btn6.setDisable(true);
		}

		r=mem.thisCollege.getRoom("C13");
		fal=b.get(r); System.out.println(r);
		if(fal.equals(true))
		{btn7.setStyle("-fx-background-color: #aa8cc5; ");
		btn7.setDisable(false);
	}
		else{
			btn7.setStyle("-fx-background-color: #FF5252; ");

			btn7.setDisable(true);
		}


		r=mem.thisCollege.getRoom("C21");
		System.out.println(r);
		fal=b.get(r); System.out.println(r);
		if(fal.equals(true))
		{btn8.setStyle("-fx-background-color: #aa8cc5; ");
		btn8.setDisable(false);
	}
		else{
			btn8.setStyle("-fx-background-color: #FF5252; ");

			btn8.setDisable(true);
		}
		r=mem.thisCollege.getRoom("C22");
		fal=b.get(r); System.out.println(r);
		if(fal.equals(true))
		{ btn10.setStyle("-fx-background-color: #aa8cc5; ");
		btn10.setDisable(false);
	}
		else{
			btn10.setStyle("-fx-background-color: #FF5252; ");

			btn10.setDisable(true);
		}
		r=mem.thisCollege.getRoom("C23");
		fal=b.get(r); System.out.println(r);
		if(fal.equals(true))
		{btn11.setStyle("-fx-background-color: #aa8cc5; ");
		btn11.setDisable(false);
	}
		else{	   btn11.setStyle("-fx-background-color: #FF5252; ");

		btn11.setDisable(true);
		}

		r=mem.thisCollege.getRoom("LR1");
		fal=b.get(r); System.out.println(r);
		if(fal.equals(true))
		{btn15.setStyle("-fx-background-color: #aa8cc5; ");
		btn15.setDisable(false);
	}
		else{
			btn15.setStyle("-fx-background-color: #FF5252; ");

			btn15.setDisable(true);
		}
		r=mem.thisCollege.getRoom("LR2");
		fal=b.get(r); System.out.println(r);
		if(fal.equals(true))
		{btn19.setStyle("-fx-background-color: #aa8cc5; ");
		btn19.setDisable(false);
}
		else{
			btn19.setStyle("-fx-background-color: #FF5252; ");

			btn19.setDisable(true);
		}
		r=mem.thisCollege.getRoom("LR3");
		fal=b.get(r); System.out.println(r);
		if(fal.equals(true))
		{btn12.setStyle("-fx-background-color: #aa8cc5; ");
		btn12.setDisable(false);
}
		else{
			btn12.setStyle("-fx-background-color: #FF5252; ");

			btn12.setDisable(true);
		}
		r=mem.thisCollege.getRoom("C24");
		fal=b.get(r); System.out.println(r);
		if(fal.equals(true))
		{C24.setStyle("-fx-background-color: #aa8cc5; ");
		C24.setDisable(false);
}
		else{
			C24.setStyle("-fx-background-color: #FF5252; ");

			C24.setDisable(true);
		}

		r=mem.thisCollege.getRoom("S01");
		fal=b.get(r); System.out.println(r);
		if(fal.equals(true))
		{btn123.setStyle("-fx-background-color: #aa8cc5; ");
		btn123.setDisable(false);
}
		else{
			btn123.setStyle("-fx-background-color: #FF5252; ");

			btn123.setDisable(true);
		}
		r=mem.thisCollege.getRoom("S02");
		fal=b.get(r); System.out.println(r);
		if(fal.equals(true))
		{btn1.setStyle("-fx-background-color: #aa8cc5; ");
		btn1.setDisable(false);
	}
		else{
			btn1.setStyle("-fx-background-color: #FF5252; ");

			btn1.setDisable(true);
		}	   //h.getKey().getRoom_number();

		r=mem.thisCollege.getRoom("L21");
		fal=b.get(r); System.out.println(r);
		if(fal.equals(true))
		{btn14.setStyle("-fx-background-color: #aa8cc5; ");
		btn14.setDisable(false);
	}
		else{
			btn14.setStyle("-fx-background-color: #FF5252; ");

			btn14.setDisable(true);
		}

		r=mem.thisCollege.getRoom("L22");
		fal=b.get(r); System.out.println(r);
		if(fal.equals(true))
		{btn20.setStyle("-fx-background-color: #aa8cc5; ");
		btn20.setDisable(false);
}
		else{
			btn20.setStyle("-fx-background-color: #FF5252; ");

			btn20.setDisable(true);
		}


		r=mem.thisCollege.getRoom("L23");
		fal=b.get(r); System.out.println(r);
		if(fal.equals(true))
		{btn16.setStyle("-fx-background-color: #aa8cc5; ");
		btn16.setDisable(false);

		}
		else{
			btn16.setStyle("-fx-background-color: #FF5252; ");

			btn16.setDisable(true);
		}

		//     for(Stringggggg KeyValue){ Room ne=Room.getInstance(String, college);


		//   r=Room.getInstance("L31", college);
		//   fal=b.get(r);
		//   if(fal.equals(true))





	}
}