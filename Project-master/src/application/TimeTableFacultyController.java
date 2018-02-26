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
 * 
 * <p> This is timetableFaculty contoller associated with the timetimefaculty.fxml </p>
 *  <p> It as the name suggest handles the display of timetable  in java</p>
 * <p>It also reflects the changes done with  ADD/ DROP in a course.    </p>
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

public class TimeTableFacultyController {
	Member mem;
	  @FXML
	    ListView<String> one;
	  @FXML
	    ListView<String> two;
	  @FXML
	    ListView<String> three;
	  @FXML
	    ListView<String> four;
	  @FXML
	  Button back;
	  @FXML
	    ListView<String> five;
	  ObservableList<String> onelist = FXCollections.observableArrayList();
	  ObservableList<String> twolist = FXCollections.observableArrayList();
	  ObservableList<String> threelist = FXCollections.observableArrayList();
	  ObservableList<String> fourlist = FXCollections.observableArrayList();
	  ObservableList<String> fivelist = FXCollections.observableArrayList();
    @FXML
    Button timetable;
    @FXML
    Button myprof ;
    @FXML
    Button myroo;
     /**
     *@throws IOException If an input or output exception occurs.
     *ttClick  loads the timetable of faculty via the TimeTable.fxml
     *
     */
   
   
    @FXML
    private void ttClick(ActionEvent event) throws IOException{
    	Stage stage = null; 
        Parent root = null;
        
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("TimeTable.fxml"));
        stage=(Stage) timetable.getScene().getWindow();
        root = (Parent)fxmlLoader.load();
        TimeTableController controller = fxmlLoader.<TimeTableController>getController();
        Faculty sw=(Faculty)mem;
        for(Course c:sw.TimeTable){
        	for(event e:c.arr){
        		if(e.day.equals("Monday")){
        			controller.threelist.add(c.acronym+" "+e.toString());
        		}
        		else if(e.day.equals("Tuesday")){
        			controller.fourlist.add(c.acronym+" "+e.toString());
        		}
        		else if(e.day.equals("Wednesday")){
        			controller.fivelist.add(c.acronym+" "+e.toString());
        		}
        		else if(e.day.equals("Thursday")){
        			controller.onelist.add(c.acronym+" "+e.toString());
        		}
        		else if(e.day.equals("Friday")){
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
    private void one(ActionEvent event) throws IOException{
    	//one.add
    }
    
     /**
    *@throws IOException If an input or output exception occurs.
    *myprofClick  loads the profile of faculty 
    *
    */
    @FXML
    private void myprofClick(ActionEvent event) throws IOException{
    	Stage stage=null;
    	Parent root=null;
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Faculty.fxml"));

		stage=(Stage) myprof.getScene().getWindow();
		root = (Parent)fxmlLoader.load();
		FacultyController controller1 = fxmlLoader.<FacultyController>getController();
		controller1.name.setText(mem.Name);

		
		controller1.mem=mem;
		
		Faculty sw=(Faculty)controller1.mem;
        for(Course c:sw.TimeTable){
        	controller1.onelist.add(c.name);
        }
        controller1.ListCourse.setItems(controller1.onelist);
		controller1.emailid.setText(mem.email);
		//System.out.println(mem.Name);
		Scene scene = new Scene(root); scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
       }
        /**
     *@throws IOException If an input or output exception occurs.
     *myrooClick  loads all the  requests of faculty ,in case the faculty wants to cancel it
     *
     */
      
    @FXML
    private void myrooClick(ActionEvent event) throws IOException{
    	 Stage stage = null; 
         Parent root = null; 
         FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("pendings.fxml"));
         stage=(Stage) myroo.getScene().getWindow();
         root = (Parent)fxmlLoader.load();
         pendingFacultyController controller = fxmlLoader.<pendingFacultyController>getController();
         controller.mem=mem;
//         System.out.println(controller.mem.Name+" hogaya hoga");
         Scene scene = new Scene(root); scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
         stage.setScene(scene);
         stage.show();
       }
   
}

