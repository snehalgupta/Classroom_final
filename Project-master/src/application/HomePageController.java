package application;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * <p>HomePageController Class serves as application start display </p>
 * <p> it contains sign up and login display functionalities which gets redirected to signUpController and Student/Admin/Faculty Controller </p>
 * 
 * @author anush
 *
 */

public class HomePageController {
	College college;
	@FXML
	Button Admin;
	@FXML
	Button Faculty;
	@FXML
	Button Student;
	@FXML
	Button Login;
	@FXML
	TextField username;
	@FXML
	PasswordField password;

	@FXML
	AnchorPane Pane1;

	@FXML
	private void AdminClick(ActionEvent event) throws IOException{
		Stage stage = null; 
		Parent root = null; 
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SIGNUP.fxml"));
		stage=(Stage) Admin.getScene().getWindow();
		root = (Parent)fxmlLoader.load();
		SignupController controller = fxmlLoader.<SignupController>getController();
		controller.type="Admin";
		controller.college=college;
		Scene scene = new Scene(root); scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
	}
	@FXML
	private void FacultyClick(ActionEvent event) throws IOException{
		Stage stage = null; 
		Parent root = null; 
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SIGNUP.fxml"));
		stage=(Stage) Faculty.getScene().getWindow();
		root = (Parent)fxmlLoader.load();
		SignupController controller = fxmlLoader.<SignupController>getController();
		controller.type="Faculty";
		controller.college=college;
		Scene scene = new Scene(root); scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
	}
	@FXML
	private void StudentClick(ActionEvent event) throws IOException{
		Stage stage = null; 
		Parent root = null; 
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SIGNUP.fxml"));
		stage=(Stage) Student.getScene().getWindow();
		root = (Parent)fxmlLoader.load();
		SignupController controller = fxmlLoader.<SignupController>getController();
		controller.type="Student";
		controller.college=college;
		
		Scene scene = new Scene(root); scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
	}
	@FXML
	private void LoginClick(ActionEvent event) throws IOException{

		Stage stage = null; 
		Parent root = null; 
		int flag=0;
		Member yo; 
		try{
		for(Member m:college.MemberList)
		{
			System.out.println("for loop");
			System.out.println(m.email+" "+m.password+" "+m.getClass().getSimpleName());
			if(username.getText().equals(m.email)&& password.getText().equals(m.password)) {
				if(m.getClass().getSimpleName().equals("Admin"))
				{
					FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Admin.fxml"));

					stage=new Stage();
					root = (Parent)fxmlLoader.load();
					AdminController controller1 = fxmlLoader.<AdminController>getController();
					controller1.name.setText(m.Name);

					
					controller1.mem=m;
					controller1.emailid.setText(m.email);
					
					System.out.println(m.Name);
					Scene scene = new Scene(root); scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
					stage.setScene(scene);
					stage.show();
					flag=1;
					break;
				}
				if(m.getClass().getSimpleName().equals("Student"))
				{
					FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Student.fxml"));

					stage=new Stage();
					root = (Parent)fxmlLoader.load();
					StudentController controller1 = fxmlLoader.<StudentController>getController();
					controller1.name.setText(m.Name);

					
					controller1.mem=m;
					
					Student sw=(Student)controller1.mem;
			        for(Course c:sw.TimeTable){
			        	controller1.onelist.add(c.name);
			        }
			        controller1.list.setItems(controller1.onelist);
					controller1.emailid.setText(m.email);
					System.out.println(m.Name);
					Scene scene = new Scene(root); scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
					stage.setScene(scene);
					stage.show();
					flag=1;
					break;
				}
				if(m.getClass().getSimpleName().equals("Faculty"))
				{
					FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Faculty.fxml"));

					stage=new Stage();
					root = (Parent)fxmlLoader.load();
					FacultyController controller1 = fxmlLoader.<FacultyController>getController();
					System.out.println(m.Name);
					controller1.mem=m;
					controller1.name.setText(m.Name);
					Faculty hj=(Faculty)controller1.mem;
					for(Course cv : hj.TimeTable){
						controller1.onelist.add(cv.name);
					}
					controller1.ListCourse.setItems(controller1.onelist);
					
					controller1.emailid.setText(m.email);
					System.out.println(m.Name);
					Scene scene = new Scene(root); scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
					stage.setScene(scene);
					stage.show();
					flag=1;
					break;
				}
			}
		}
		if(flag == 0){
			throw new IncorrectException("Invalid Username or Password");
		}}
		catch(IncorrectException e){
			 FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("bekaar.fxml"));
             root = (Parent)fxmlLoader.load();
             bekaarController controllerw = fxmlLoader.<bekaarController>getController();
             controllerw.sig.setText(e.getMessage());
             Stage stage1=new Stage();
             
             Scene scene = new Scene(root,300,300); scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
             stage1.setScene(scene);
             stage1.show();
		}
	}
}
class IncorrectException extends Exception{
	public IncorrectException(String message){
		super (message);
	}
}