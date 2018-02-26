package application;

import java.io.IOException;

import com.jfoenix.controls.JFXTextArea;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class Room_FormController {
	Member mem;
	@FXML
	TextField capacity;
	@FXML
	TextField date;

	@FXML
	TextField end;

	@FXML
	TextField start;

	@FXML
	Label label;

	@FXML
	JFXTextArea purpose;
	
	
	
	
	@FXML
	TextField roomCap;
    @FXML
    Button btn0;
    @FXML
    Button back;
    
    @FXML
    private void btn0Click(ActionEvent event) throws IOException{
    	String timeslot=start.getText().replaceAll(":","")+"-"+end.getText().replaceAll(":", "");
    	Request req=new Request(purpose.getText(),mem.thisCollege.getRoom(label.getText()),Integer.parseInt(capacity.getText()),mem,date.getText(),timeslot);
    	if(req.Capacity>req.prefered_room.Capacity)
    	{
    		req.status=-1;
    		System.out.println("CAPACITY exceeded that given room capacity;");
    	}
 
    	
    	mem.thisCollege.serialize();
    	mem.thisCollege.RequestList.add(req);
    	mem.MyBookings.add(req);
    	System.out.println(mem.thisCollege.RequestList.size()+"OKAY SIZE HI TOH HAI");

    	for(Request re:mem.thisCollege.RequestList) {
    		System.out.println(7898789);
    		System.out.println(re);
    	}
    	
    	
    	
    	
    	
    	
    	
    	mem.thisCollege.serialize();
    	
    	
    	System.out.println(mem.email+"ihniho");
        Stage stage = null; 
        Parent root = null; 
        
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("View_Rooms.fxml"));
        stage=(Stage) back.getScene().getWindow();
        root = (Parent)fxmlLoader.load();
        View_RoomsController controller = fxmlLoader.<View_RoomsController>getController();
        controller.mem=mem;
        Scene scene = new Scene(root);
	    scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

        stage.setScene(scene);
        stage.show();

    	
    	
    	
       }
    @FXML
    private void btn1Click(ActionEvent event) throws IOException{
        Stage stage = null; 
        Parent root = null; 
        
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("View_Rooms.fxml"));
        stage=(Stage) back.getScene().getWindow();
        root = (Parent)fxmlLoader.load();
        View_RoomsController controller = fxmlLoader.<View_RoomsController>getController();
        controller.mem=mem;
        Scene scene = new Scene(root);
	    scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

        stage.setScene(scene);
        stage.show();
       }
      
}
