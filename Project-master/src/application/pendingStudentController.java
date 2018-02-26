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
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
/**
 * <p> Shows the Pending student requests which are not Accepted yet by the Admin </p>
 * <p> the Student can cancel the reuqests which are still on standby now </p>
 * @author anush
 *
 */
public class pendingStudentController {
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
	Button fetchc;
	@FXML
	Button myroo;

	private ObservableList<String> observableList = FXCollections.observableArrayList();

	@FXML
	private void ttClick(ActionEvent event) throws IOException{
        Stage stage = null; 
        Parent root = null; 
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("TimeTable.fxml"));
        stage=(Stage) timetable.getScene().getWindow();
        root = (Parent)fxmlLoader.load();
        TimeTableController controller = fxmlLoader.<TimeTableController>getController();
        controller.mem=mem;
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm()); scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stage.setScene(scene);
        stage.show();

	}
	@FXML
	private void myprofClick(ActionEvent event) throws IOException{
		Stage stage=null;
    	Parent root=null;
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Student.fxml"));

		stage=(Stage) myprof.getScene().getWindow();
		root = (Parent)fxmlLoader.load();
		StudentController controller1 = fxmlLoader.<StudentController>getController();
		controller1.name.setText(mem.Name);

		
		controller1.mem=mem;
		
		Student sw=(Student)controller1.mem;
        for(Course c:sw.TimeTable){
        	controller1.onelist.add(c.name);
        }
        controller1.list.setItems(controller1.onelist);
		controller1.emailid.setText(mem.email);
		//System.out.println(mem.Name);
		Scene scene = new Scene(root); scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
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
		System.out.println(controller.mem.Name+" hogaya hoga");
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm()); scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
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

		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm()); scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
	}





	@FXML
	private void back(ActionEvent event) throws IOException{
		Stage stage=null;
    	Parent root=null;
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Student.fxml"));

		stage=(Stage) myprof.getScene().getWindow();
		root = (Parent)fxmlLoader.load();
		StudentController controller1 = fxmlLoader.<StudentController>getController();
		controller1.name.setText(mem.Name);

		
		controller1.mem=mem;
		
		Student sw=(Student)controller1.mem;
        for(Course c:sw.TimeTable){
        	controller1.onelist.add(c.name);
        }
        controller1.list.setItems(controller1.onelist);
		controller1.emailid.setText(mem.email);
		//System.out.println(mem.Name);
		Scene scene = new Scene(root); scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
	}

	@FXML
	private void ENTER(ActionEvent event) throws IOException{
		int ik=Integer.parseInt(EnterReq.getText());
		if(ik>0&&ik<=observableList.size())
		{
			DetailsReq.setText(observableList.get(ik-1).toString());
			Cancel.setDisable(false);
		}

	}

@FXML
private void Refresh(ActionEvent event) throws IOException{
	EnterReq.setText("");
	DetailsReq.setText("");
	Cancel.setDisable(true);
	observableList = FXCollections.observableArrayList();
	System.out.println("Requests Refreshed");
	int i=1;
	for(Request r:mem.MyBookings)
	{
		System.out.println(r);
		if(r.getpending()>=5)
		{
			r.status=-1;
		}
		if(r.status==0)
		{
			observableList.add("Req#"+" "+i+" "+r.toString());
			i+=1;
		}
	}
	ListREQ.setItems(observableList);
	System.out.println(ListREQ);
//	System.out.println(ListREQ.getItems().get(0));

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
			System.out.println(r.toString()+"MATCH HUA HAI YAAR"+search);
			if(r.status==0)
			{
				r.status=-1;
			}
			//false matlab accepted
		}
	}
}




}
