package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class VerificationController {

		College college;
    
	 @FXML
	    Button signup;
	    
	    @FXML
	    Button back;
	   
	  
	    @FXML
	    TextField validk;
	    
    
    String type;
   String key;
   String name;
   String email;
   String passwd;
    @FXML
    private void homepage(ActionEvent event) throws IOException{
    	Stage stage = null; 
        Parent root = null; 
        stage=(Stage) signup.getScene().getWindow();
        try{
        if(validk.getText().equals(key)){
        	if(type.equals("Admin")){
        		Admin a1=new Admin(college,name,email,passwd);
        		college.MemberList.add(a1);
        		college.adminList.add(a1);
        		college.emails.add(email);
        		a1.thisCollege=college;
        		//a1.serialize();
        	}
        	else if(type.equals("Faculty")){
        		Faculty f1=new Faculty(college,name,email,passwd);
        		for(Course cv:college.CourseList){
        			if(cv.Instructor.equals(name)){
        				System.out.println("hann hai");
        				f1.TimeTable.add(cv);
        			}
        		}
        		college.MemberList.add(f1);
        		college.FacultyList.add(f1);
        		college.emails.add(email);
        		f1.thisCollege=college;
        		//f1.serialize();
        	}
        	else if(type.equals("Student")){
        		Student s1=new Student(college,name,email,passwd);
        		college.MemberList.add(s1);
        		college.StudentList.add(s1);
        		college.emails.add(email);
        		s1.thisCollege=college;
//        		s1.serialize();
        	}
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("HomePage.fxml"));
            stage=(Stage) back.getScene().getWindow();
            root = (Parent)fxmlLoader.load();
            HomePageController controller = fxmlLoader.<HomePageController>getController();
            controller.college=college;
            Scene scene = new Scene(root); scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
            stage.setScene(scene);
            stage.show();
        }        else{
        	throw new NotavalidkeyException("Not a valid key");
        }
        }
        catch(NotavalidkeyException e){
        	 FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("bekaar.fxml"));
             root = (Parent)fxmlLoader.load();
             bekaarController controllerw = fxmlLoader.<bekaarController>getController();
             controllerw.sig.setText(e.getMessage());
             Stage stage1=new Stage();
             
             Scene scene = new Scene(root,300,300); scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
             stage1.setScene(scene);
             stage1.show();
        }
        college.serialize();
       }
    
    @FXML
    private void homepage1(ActionEvent event) throws IOException{
        Stage stage = null; 
        Parent root = null; 
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("HomePage.fxml"));
        stage=(Stage) back.getScene().getWindow();
        root = (Parent)fxmlLoader.load();
        HomePageController controller = fxmlLoader.<HomePageController>getController();
        controller.college=college;
        college.serialize();

        Scene scene = new Scene(root); scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
}
   
}

class NotavalidkeyException extends Exception{
	public NotavalidkeyException(String message){
		super(message);
	}
}
