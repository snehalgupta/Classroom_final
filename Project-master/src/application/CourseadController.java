package application;

import java.io.IOException;

import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
/**
 *<p> ADD DROP of the courses </p>
 * @author anush
 *
 */
public class CourseadController {

    Member mem;
    @FXML
    Label added;
    @FXML
    JFXTextArea prereq;
    @FXML
    JFXTextArea postreq;
    @FXML
    JFXTextField course;
    @FXML
    JFXTextField instruct;
    @FXML
    JFXTextArea lect;
    @FXML
    Button back;
    @FXML
    Button add;
    @FXML
    Button drop;
    @FXML
    private void homepage1(ActionEvent event) throws IOException{
        Stage stage = null; 
        Parent root = null; 
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FETCH.fxml"));
        stage=(Stage) back.getScene().getWindow();
        added.setText(" ");
        root = (Parent)fxmlLoader.load();
        FetchController controller = fxmlLoader.<FetchController>getController();
        controller.mem=mem;
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm()); scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
       }
    @FXML
    private void homepage2(ActionEvent event) throws IOException{
        Student sw=(Student)mem;
        Course co=null;
        for(Course c:mem.thisCollege.CourseList){
        	if(c.name.equals(course.getText())){
        		System.out.println(c.name);
        		co=c;
        		break;
        	}
        }
        if(co != null){
        	
        	boolean fg=sw.search(co);
        	if(fg == false){
        		
        		System.out.println("added");
        		added.setText("Added");
        		sw.addCourse(co);
        		//System.out.println(co.name);
        	}
        	else{
        		added.setText("Cannot be added");
        	}
        }
       }
    @FXML
    private void homepage3(ActionEvent event) throws IOException{
    	
        Student sw=(Student)mem;
        Course co=null;
        
        for(Course c:mem.thisCollege.CourseList){
        	//System.out.println(c.name+" "+course.getText());
        	if(c.name.equals(course.getText())){
        		//System.out.println(c.name);
        		co=c;
        		break;
        	}
        	
        }
        if(sw.TimeTable.contains(co)){
        	
        sw.dropCourse(co);
        added.setText("Dropped");
        System.out.println("dropped");
        
        }
        else{
        	added.setText("cannot be dropped");
        }
        
       }
}


