package application;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 *<p> It Displays the Profile of Faculty from where it can go to TimeTable viewing , Requests Viewing and Room Booking </p>
 *
 * @author anush
 *
 */
public class FacultyController {
	Member mem;
	@FXML
	Button name;
	@FXML
	Button emailid;
	@FXML
	ListView<String> ListCourse;
	ObservableList<String> onelist = FXCollections.observableArrayList();
	@FXML
	Button tt;
	@FXML
	Button myprof ;
	@FXML
	Button viewroom;
	@FXML
	Button myroom;
	@FXML
	Button logout;
	@FXML
	AnchorPane Pane5;

	@FXML
	private void ttClick(ActionEvent event) throws IOException{
        Stage stage = null; 
        Parent root = null; 
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("TimeTableFaculty.fxml"));
        stage=(Stage) tt.getScene().getWindow();
        root = (Parent)fxmlLoader.load();
        TimeTableFacultyController controller = fxmlLoader.<TimeTableFacultyController>getController();
        Faculty sw=(Faculty)mem;
        for(Course c:sw.TimeTable){
        	for(event e:c.arr){
        		System.out.println(e.toString()+" "+e.day);
        		if(e.day.equals("Mon")){
        			System.out.println("done1");
        			controller.threelist.add(c.acronym+" "+e.toString());
        		}
        		else if(e.day.equals("Tue")){
        			System.out.println("done2");
        			controller.fourlist.add(c.acronym+" "+e.toString());
        		}
        		else if(e.day.equals("Wed")){
        			System.out.println("done3");
        			controller.fivelist.add(c.acronym+" "+e.toString());
        		}
        		else if(e.day.equals("Thu")){
        			System.out.println("done4");
        			controller.onelist.add(c.acronym+" "+e.toString());
        		}
        		else if(e.day.equals("Fri")){
        			System.out.println("done5");
        			controller.twolist.add(c.acronym+" "+e.toString());
        		}
        	}
        }
        controller.one.setItems(controller.threelist);
        controller.two.setItems(controller.twolist);
        controller.three.setItems(controller.fivelist);
        controller.four.setItems(controller.onelist);
        controller.five.setItems(controller.fourlist);
        controller.mem=mem;
        Scene scene = new Scene(root);
	    scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

        stage.setScene(scene);
        stage.show();
	}
	@FXML
	private void myprofClick(ActionEvent event) throws IOException{
	}
	@FXML
	private void myrooClick(ActionEvent event) throws IOException{
        Stage stage = null; 
        Parent root = null; 
        //viewing my room booking FACULTY
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("pending.fxml"));
        stage=(Stage) myroom.getScene().getWindow();
        root = (Parent)fxmlLoader.load();
        pendingFacultyController controller = fxmlLoader.<pendingFacultyController>getController();
        controller.mem=mem;
//        System.out.println(controller.mem.Name+" hogaya hoga");
        Scene scene = new Scene(root);
	    scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

        stage.setScene(scene);
        stage.show();

	}
	@FXML
	private void viewroomClick(ActionEvent event) throws IOException{
        Stage stage = null; 
        Parent root = null; 
        //viewing my room @FACULT

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("View_Roomsf.fxml"));
        stage=(Stage) viewroom.getScene().getWindow();
        root = (Parent)fxmlLoader.load();
        View_RoomsfController controller = fxmlLoader.<View_RoomsfController>getController();
        controller.mem=mem;
        System.out.println(controller.mem.Name+" hogaya hoga");
        Scene scene = new Scene(root);
	    scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

        stage.setScene(scene);
        stage.show();
	}
	@FXML
	private void LogoutClick(ActionEvent event) throws IOException{
        Stage stage = null; 
        Parent root = null; 
        //viewing my room @FACULT

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("HomePage.fxml"));
        stage=(Stage) logout.getScene().getWindow();
        root = (Parent)fxmlLoader.load();
        HomePageController controller = fxmlLoader.<HomePageController>getController();
        controller.college=mem.thisCollege;
//        System.out.println(controller.mem.Name+" hogaya hoga");
        Scene scene = new Scene(root);
	    scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

        stage.setScene(scene);
        stage.show();
	}

}
