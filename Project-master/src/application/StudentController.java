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
 *  <p> Once a Student signs in ,Student Controller Class manages where it will proceed to . </p>
 * <p> Options being MyProfile , Fetch Courses , logout , view timetable , view Rooms, my bookings </p>
 * <p> Used Stylesheet style.caa </p>
 * @author anushka
 * 
 *
 */

public class StudentController {
	Member mem;
	 @FXML
	    ListView<String> list;
	 ObservableList<String> onelist = FXCollections.observableArrayList();
    @FXML
    Button timetable;
    @FXML
    Button myprof ;
    @FXML
    Button myroo1 ;
    @FXML
    Button cou1 ;
    @FXML
    Button cou2 ;
    @FXML
    Button cou3 ;
    @FXML
    Button myroo;
    @FXML
    Button fetchc;
    @FXML
    Button logout;
    @FXML
    AnchorPane Pane2;
    @FXML
    Button name;
    @FXML
    Button emailid; 
    @FXML
    private void ttClick(ActionEvent event) throws IOException{
    	Stage stage = null; 
        Parent root = null;
        
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("TimeTable.fxml"));
        stage=(Stage) timetable.getScene().getWindow();
        root = (Parent)fxmlLoader.load();
        TimeTableController controller = fxmlLoader.<TimeTableController>getController();
        Student sw=(Student)mem;
        for(Course c:sw.TimeTable){
        	for(event e:c.arr){
        		if(e.day.equals("Mon")){
        			controller.threelist.add(c.acronym+" "+e.toString());
        		}
        		else if(e.day.equals("Tue")){
        			controller.fourlist.add(c.acronym+" "+e.toString());
        		}
        		else if(e.day.equals("Wed")){
        			controller.fivelist.add(c.acronym+" "+e.toString());
        		}
        		else if(e.day.equals("Thu")){
        			controller.onelist.add(c.acronym+" "+e.toString());
        		}
        		else if(e.day.equals("Fri")){
        			controller.twolist.add(c.acronym+" "+e.toString());
        		}
        	}
        }
        controller.one.setItems(controller.onelist);
        controller.two.setItems(controller.twolist);
        controller.three.setItems(controller.threelist);
        controller.four.setItems(controller.fourlist);
        controller.five.setItems(controller.fivelist);
        controller.mem=mem;
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm()); scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
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
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("View_Rooms.fxml"));
        stage=(Stage) myroo.getScene().getWindow();
        root = (Parent)fxmlLoader.load();
        View_RoomsController controller = fxmlLoader.<View_RoomsController>getController();
        controller.mem=mem;
        //System.out.println(controller.mem.Name+" hogaya hoga");
        Scene scene = new Scene(root); scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
              }
    @FXML
    private void myroo1Click(ActionEvent event) throws IOException{
        
        
        
        Stage stage = null; 
        Parent root = null; 
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("pendings.fxml"));
        stage=(Stage) myroo.getScene().getWindow();
        root = (Parent)fxmlLoader.load();
        pendingStudentController controller = fxmlLoader.<pendingStudentController>getController();
        controller.mem=mem;
//        System.out.println(controller.mem.Name+" hogaya hoga");
        Scene scene = new Scene(root); scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stage.setScene(scene);
        stage.show();

        
        
        
        
        
        
       }
    @FXML
    private void couClick1(ActionEvent event) throws IOException{
        Stage stage = null; 
        Parent root = null; 
        stage=(Stage) cou1.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("Course.fxml"));
        Scene scene = new Scene(root); scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
       }
    @FXML
    private void couClick2(ActionEvent event) throws IOException{
        Stage stage = null; 
        Parent root = null; 
        stage=(Stage) cou2.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("Course.fxml"));
        Scene scene = new Scene(root); scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
       }
    @FXML
    private void couClick3(ActionEvent event) throws IOException{
        Stage stage = null; 
        Parent root = null; 
        stage=(Stage) cou3.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("Course.fxml"));
        Scene scene = new Scene(root); scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
       }
    @FXML
    private void fetchcClick(ActionEvent event) throws IOException{
        Stage stage = null; 
        Parent root = null; 
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FETCH.fxml"));
        stage=(Stage) fetchc.getScene().getWindow();
        root = (Parent)fxmlLoader.load();
        FetchController controller = fxmlLoader.<FetchController>getController();
        controller.mem=mem;
        Scene scene = new Scene(root); scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
       }
    @FXML
    private void logoutClick(ActionEvent event) throws IOException{
        Stage stage = null; 
        Parent root = null; 
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("HomePage.fxml"));
        stage=(Stage) fetchc.getScene().getWindow();
        root = (Parent)fxmlLoader.load();
        HomePageController controller = fxmlLoader.<HomePageController>getController();
        controller.college=mem.thisCollege;
        Scene scene = new Scene(root); scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
       }
}

