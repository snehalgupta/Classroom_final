package application;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
/**
 * <p> Shows the  Faculty requests which are BOOKED</p>
 * <p> the Faculty can cancel its Booked requests  </p>
 * @author anush
 *
 */
public class pendingFacultyController {
	Member mem;
	@FXML
	Button Cancel;
	@FXML
	Button refresh;

	@FXML
	TextField EnterReq;
	@FXML
	ListView<String> ListREQ;
	@FXML
	JFXButton back;
	@FXML
	Button EnterButton;
	@FXML
	TextField DetailsReq;
	@FXML
	Button timetable;
	@FXML
	Button myprof;
	@FXML
	Button myroo;

	private ObservableList<String> observableList = FXCollections.observableArrayList();

	@FXML
	private void ttClick(ActionEvent event) throws IOException{
        Stage stage = null; 
        Parent root = null; 
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("TimeTablefaculty.fxml"));
        stage=(Stage) timetable.getScene().getWindow();
        root = (Parent)fxmlLoader.load();
        TimeTableFacultyController controller = fxmlLoader.<TimeTableFacultyController>getController();
        controller.mem=mem;
        Scene scene = new Scene(root); scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stage.setScene(scene);
        stage.show();

	}
	@FXML
	private void myprofClick(ActionEvent event) throws IOException{
        Stage stage = null; 
        Parent root = null; 
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Faculty.fxml"));
        stage=(Stage) myprof.getScene().getWindow();
        root = (Parent)fxmlLoader.load();
        FacultyController controller = fxmlLoader.<FacultyController>getController();
        controller.mem=mem;
        System.out.println(controller.mem.Name+" hogaya hoga");
        Scene scene = new Scene(root); scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
	}
	@FXML
	private void myrooClick(ActionEvent event) throws IOException{
		Stage stage = null; 
		Parent root = null; 
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("View_Roomsf.fxml"));
		stage=(Stage) myroo.getScene().getWindow();
		root = (Parent)fxmlLoader.load();
		View_RoomsfController controller = fxmlLoader.<View_RoomsfController>getController();
		controller.mem=mem;
		System.out.println(controller.mem.Name+" hogaya hoga");
		Scene scene = new Scene(root); scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
	}




	@FXML
	private void back(ActionEvent event) throws IOException{
		  Stage stage = null; 
	        Parent root = null; 
	        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Faculty.fxml"));
	        stage=(Stage) myprof.getScene().getWindow();
	        root = (Parent)fxmlLoader.load();
	        FacultyController controller = fxmlLoader.<FacultyController>getController();
	        controller.mem=mem;
	        controller.name.setText(mem.Name);
	        controller.emailid.setText(mem.email);

	        System.out.println(controller.mem.Name+" hogaya hoga");
	        Scene scene = new Scene(root); scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
	        stage.setScene(scene);
	        stage.show();
			}

	@FXML
	private void ENTER(ActionEvent event) throws IOException{
		int ik=Integer.parseInt(EnterReq.getText());
		if(ik<=observableList.size())
		{
			DetailsReq.setText(observableList.get(ik-1).toString());
			Cancel.setDisable(false);
		}

	}

@FXML
private void Refresh(ActionEvent event) throws IOException{
	EnterReq.setText("");
	DetailsReq.setText("");
	Cancel.setDefaultButton(true);;
	observableList = FXCollections.observableArrayList();
	System.out.println("Requests Refreshed");
	int i=1;
	for(Request r:mem.MyBookings)
	{
		if(r.status!=-1)
		{
			observableList.add("Req#"+" "+i+" "+r.toString());
			i+=1;
		}
	}
	ListREQ.setItems(observableList);
	System.out.println(ListREQ);
	//System.out.println(ListREQ.getItems().get(0));

}



@FXML
private void CANCEL(ActionEvent event) throws IOException{
	int ik=Integer.parseInt(EnterReq.getText());
	String search=ListREQ.getItems().get(ik-1);
	System.out.println(search+"ye hai search");
	for(Request r:mem.MyBookings)
	{
		System.out.println();
		if(("Req#"+" "+ik+" "+r.toString()).equals(search))
		{
			System.out.println("Req#"+" "+ik+" "+r.toString()+"MATCH HUA HAI YAAR"+search);
//			if(r.status==0)
			{
				r.status=-1;
				r.prefered_room.Booking.remove(r.date);

			}
			//false matlab accepted
		}
	}
}




}
