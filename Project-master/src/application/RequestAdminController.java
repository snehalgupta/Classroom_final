package application;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTimePicker;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
/**
 *<p> Request Admin Controller manages all the requests made so far . Based on the status of the requests, it shows their details</p>
 * <p>  Requests can be Cancelled and Accepted by the Admin      </p>
 * 
 *  @author Anushka Bhandari
 * @author Snehal Gupta
 * @version 1.0
 * @since November 11, 2017
 */
public class RequestAdminController {
	Member mem;
	@FXML
	Button myprof;
	@FXML
	Button myroo;
	@FXML
	JFXButton back;

	//Student stu;
	@FXML
	ListView<String> list;//=new ListView<String>();
	@FXML
	TextField reqnum;
	@FXML
	TextField details;

	@FXML
	Button Enter;
	@FXML
	Button Accept;
	@FXML
	Button Cancel;
	@FXML
	Button refresh;
	int x=0;
	private ObservableList<String> observableList = FXCollections.observableArrayList();
	@FXML
	/**
	 *myprofClick redirects to the Admin Controller Class to show the Admin Page
	 * @param event
	 * @throws IOException
	 */
	private void myprofClick(ActionEvent event) throws IOException{
        Stage stage = null; 
        Parent root = null; 
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Admin.fxml"));
        stage=(Stage) myprof.getScene().getWindow();
        root = (Parent)fxmlLoader.load();
        AdminController controller = fxmlLoader.<AdminController>getController();
        controller.mem=mem;
        System.out.println(controller.mem.Name+" hogaya hoga");
        Scene scene = new Scene(root); scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
	}
	@FXML
	/**
	 * redirects to the view my requests page wh
	 * @param event
	 * @throws IOException
	 */
	private void myrooClick(ActionEvent event) throws IOException{
		Stage stage = null; 
		Parent root = null; 
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("View_Rooms.fxml"));
		stage=(Stage) myroo.getScene().getWindow();
		root = (Parent)fxmlLoader.load();
		View_RoomsController controller = fxmlLoader.<View_RoomsController>getController();
		controller.mem=mem;
		System.out.println(controller.mem.Name+" hogaya hoga");
		Scene scene = new Scene(root); scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
	}
/**
 * refreshses the requests 
 * @param event
 * @throws IOException
 */
	@FXML
	private void Refresh(ActionEvent event) throws IOException{
		reqnum.setText("");
		details.setText("");
		Cancel.setDisable(true);
		Accept.setDisable(true);

		observableList = FXCollections.observableArrayList();
		System.out.println("Requests Refreshed");
		int i=1;
		for(Request r:mem.thisCollege.RequestList)
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
		list.setItems(observableList);
		System.out.println(list);
		//System.out.println(list.getItems().get(0));

	}

	@FXML
	private void enter(ActionEvent event) throws IOException{
		int ik=Integer.parseInt(reqnum.getText());
		System.out.println("OBSERVABLE LIST KA SIZE"+observableList.size());
if(ik>0&&ik<=observableList.size())
{
		details.setText(observableList.get(ik-1).toString());
		Accept.setDisable(false);
		Cancel.setDisable(false);
}

	}
		/**
	 * accepts the current selected request number from the list
	 * @param event
	 * @throws IOException
	 */
	@FXML
	private void accept(ActionEvent event) throws IOException{
		int ik=Integer.parseInt(reqnum.getText());
		String search=list.getItems().get(ik-1);

		System.out.println(search +"SEARCJ");
		for(Request r:mem.thisCollege.RequestList)
		{
			System.out.println("match toh ho jaye");
			System.out.println(("Req#"+" "+ik+" "+r.toString()));

			
			if(("Req#"+" "+ik+" "+r.toString()).equals(search))

			{
				if(r.status==0)
				{
					
					r.status=1;
					r.prefered_room.book(r.date, r.timeslot);
				}
				//false matlab accepted
			}
		}


	}

	/**
	 * rejects the current selected request number from the list
	 * @param event
	 * @throws IOException
	 */
@FXML
	private void Cancel(ActionEvent event) throws IOException{
		int ik=Integer.parseInt(reqnum.getText());
		String search=list.getItems().get(ik-1);
		System.out.println(search +"SEARCJ");
		for(Request r:mem.thisCollege.RequestList)
		{
			System.out.println(("Req#"+" "+ik+" "+r.toString()));
			if(("Req#"+" "+ik+" "+r.toString()).equals(search))
			{
				if(r.status==0)
				{
					r.status=-1;
					r.prefered_room.Booking.remove(r.date);

				}
				//false matlab accepted
			}
		}
	}


/**
 * goes back to Admin profile
 * @param event
 * @throws IOException
 */
	@FXML
		private void back(ActionEvent event) throws IOException{
        Stage stage = null; 
        Parent root = null; 
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Admin.fxml"));
        stage=(Stage) back.getScene().getWindow();
        root = (Parent)fxmlLoader.load();
        AdminController controller = fxmlLoader.<AdminController>getController();
        controller.mem=mem;
        System.out.println(controller.mem.Name+" hogaya hoga");
        Scene scene = new Scene(root); scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
	}


}
