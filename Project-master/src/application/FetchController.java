package application;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;
/**
 * <p> Fetch Controller fetches the courses that are associated with the keyword search</p>
 * <p> at first it displays all the courses in current semester </p>
 * <p> Student can click and add a course to his/her timetable </p>
 * @author anush
 * 
 *
 */

public class FetchController {
	Member mem;

	@FXML
	Label normal;
	@FXML
	JFXTextField yass;
	@FXML
	Button timetable;
	@FXML
	Button myprof ;
	@FXML
	Button myroo;
	@FXML
	Button fetchc;
	@FXML
	Button back;
	@FXML
	AnchorPane Pane2;
	@FXML
	Button DM;
	@FXML
	Button NT;
	@FXML
	Button AP;
	@FXML
	Button PoK;
	@FXML
	Button Psy;
	@FXML
	Button CO;	
	@FXML
	Button ISI;
	@FXML
	Button PO;
	@FXML
	Button GO;

	@FXML
	Button M3;
	@FXML
	Button SnS;
	@FXML
	Button RA;
	@FXML
	Button TPEE;
	@FXML
	Button TA;
	@FXML
	Button ES;
	@FXML
	Button IDE;
	@FXML
	Button IMS;


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
        //System.out.println(controller.mem.Name+" hogaya hoga");
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
	private void onGo(ActionEvent event) throws IOException{
		HashMap<Course,Boolean> set=new HashMap<Course,Boolean>();
		String search=yass.getText();
		System.out.println(search);
		normal.setText("Matching Courses");
		for(Course coarse:mem.thisCollege.CourseList) 
		{
			System.out.println(coarse.acronym);
			boolean lolwa=coarse.findkeyword(search);
			{
				set.put(coarse, lolwa);
			}
		}
		for(Entry<Course,Boolean> h:set.entrySet()) {
			System.out.println(h.getKey().acronym+" "+h.getValue());
		}
		
		
		
		
		
		for(Entry<Course,Boolean> h:set.entrySet()) {
			String x=h.getKey().acronym;
			System.out.println("dekho chal jao pyaar se"+h.getValue());
			if(h.getValue()==true)
			{
				if(x.equals("DM"))
				{System.out.println(h.getValue());

					DM.setVisible(true);
				}
				else if(x.equals("M-III"))
				{System.out.println(h.getValue());

					M3.setVisible(true);
				}
				else if(x.equals("RA"))
				{System.out.println(h.getValue());

					RA.setVisible(true);
				}
				else if(x.equals("NT"))
				{
					System.out.println(h.getValue());

					NT.setVisible(true);
				}
				else if(x.equals("PoK"))
				{
					System.out.println(h.getValue());

					PoK.setVisible(true);
				}
				else if(x.equals("Psy"))
				{
					System.out.println(h.getValue());

					Psy.setVisible(true);
				}
				else if(x.equals("ES"))
				{
					System.out.println(h.getValue());

					ES.setVisible(true);
				}
				else if(x.equals("IDE"))
				{
					System.out.println(h.getValue());

					IDE.setVisible(true);
				}
				else if(x.equals("IMS"))
				{
					System.out.println(h.getValue());

					IMS.setVisible(true);
				}
				else if(x.equals("ISI"))
				{
					System.out.println(h.getValue());

					ISI.setVisible(true);
				}


				else if(x.equals("AP"))
				{System.out.println(h.getValue());

					AP.setVisible(true);
				}
				else if(x.equals("S&S"))
				{System.out.println(h.getValue());

					SnS.setVisible(true);
				}
				else if(x.equals("PO"))
				{System.out.println(h.getValue());

					PO.setVisible(true);
				}
				else if(x.equals("CO"))
				{System.out.println(h.getValue());

					CO.setVisible(true);
				}
				else if(x.equals("TA"))
				{System.out.println(h.getValue());

					TA.setVisible(true);
				}
				else if(x.equals("TPEE"))
					System.out.println(h.getValue());
					TPEE.setVisible(true);
				}

			
			if(h.getValue()==false)
			{	
				if(x.equals("DM"))
				{System.out.println(h.getValue());

					DM.setVisible(false);
				}
				else if(x.equals("M-III"))
				{System.out.println(h.getValue());

					M3.setVisible(false);
				}
				else if(x.equals("RA"))
				{System.out.println(h.getValue());

					RA.setVisible(false);
				}
				else if(x.equals("NT"))
				{
					System.out.println(h.getValue());

					NT.setVisible(false);
				}
				else if(x.equals("PoK"))
				{
					System.out.println(h.getValue());

					PoK.setVisible(false);
				}
				else if(x.equals("Psy"))
				{
					System.out.println(h.getValue());

					Psy.setVisible(false);
				}
				else if(x.equals("ES"))
				{
					System.out.println(h.getValue());

					ES.setVisible(false);
				}
				else if(x.equals("IDE"))
				{
					System.out.println(h.getValue());

					IDE.setVisible(false);
				}
				else if(x.equals("IMS"))
				{
					System.out.println(h.getValue());

					IMS.setVisible(false);
				}
				else if(x.equals("ISI"))
				{
					System.out.println(h.getValue());

					ISI.setVisible(false);
				}


				else if(x.equals("AP"))
				{System.out.println(h.getValue());

					AP.setVisible(false);
				}
				else if(x.equals("S&S"))
				{System.out.println(h.getValue());

					SnS.setVisible(false);
				}
				else if(x.equals("PO"))
				{System.out.println(h.getValue());

					PO.setVisible(false);
				}
				else if(x.equals("CO"))
				{System.out.println(h.getValue());

					CO.setVisible(false);
				}
				else if(x.equals("TA"))
				{System.out.println(h.getValue());

					TA.setVisible(false);
				}
				else if(x.equals("TPEE"))
					System.out.println(h.getValue());
					TPEE.setVisible(false);
				}
			}

		}


	
	@FXML
	private void myprofClick1(ActionEvent event) throws IOException{
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
	private void couClick1(ActionEvent event) throws IOException{
		Stage stage = null; 
		Parent root = null; 
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Coursead.fxml"));
	    stage=(Stage) CO.getScene().getWindow();
	    root = (Parent)fxmlLoader.load();
	    CourseadController controller = fxmlLoader.<CourseadController>getController();
	    for(Course c:mem.thisCollege.CourseList){
	    	if(c.acronym.equals("CO")){
	    		String p1="";
	    		String p2="";
	    		for(int tp=0;tp<c.preconditions.length;tp++){
	    			p1+=c.preconditions[tp]+" ";
	    		}
	    		for(int ry=0;ry<c.postconditions.length;ry++){
	    			p2+=c.postconditions[ry]+" ";
	    		}
	    		controller.course.setText(c.name);
	    		controller.prereq.setText(p1);
	    		controller.postreq.setText(p2);
	    		controller.instruct.setText(c.Instructor);
	    		String hy="";
	    		for(int cv=0;cv<c.arr.size();cv++){
	    			hy+=c.arr.get(cv).day+" : "+c.arr.get(cv).start+" - "+c.arr.get(cv).end+"\n";
	    		}
	    		controller.lect.setText(hy);
	    		break;
	    	}
	    }
	    controller.mem=mem;
		Scene scene = new Scene(root);
		 scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
	}
	@FXML
	private void couClick0(ActionEvent event) throws IOException{
		Stage stage = null; 
		Parent root = null; 
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Coursead.fxml"));
	    stage=(Stage) DM.getScene().getWindow();
	    root = (Parent)fxmlLoader.load();
	    CourseadController controller = fxmlLoader.<CourseadController>getController();
	    for(Course c:mem.thisCollege.CourseList){
	    	if(c.acronym.equals("DM")){
	    		String p1="";
	    		String p2="";
	    		for(int tp=0;tp<c.preconditions.length;tp++){
	    			p1+=c.preconditions[tp]+" ";
	    		}
	    		for(int ry=0;ry<c.postconditions.length;ry++){
	    			p2+=c.postconditions[ry]+" ";
	    		}
	    		controller.course.setText(c.name);
	    		controller.prereq.setText(p1);
	    		controller.postreq.setText(p2);
	    		controller.instruct.setText(c.Instructor);
	    		String hy="";
	    		for(int cv=0;cv<c.arr.size();cv++){
	    			hy+=c.arr.get(cv).day+" : "+c.arr.get(cv).start+" - "+c.arr.get(cv).end+"\n";
	    		}
	    		controller.lect.setText(hy);
	    		break;
	    	}
	    }
	    controller.mem=mem;
		Scene scene = new Scene(root);
		 scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
	}
	@FXML
	private void couClick2(ActionEvent event) throws IOException{
		Stage stage = null; 
		Parent root = null; 
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Coursead.fxml"));
	    stage=(Stage) AP.getScene().getWindow();
	    root = (Parent)fxmlLoader.load();
	    CourseadController controller = fxmlLoader.<CourseadController>getController();
	    for(Course c:mem.thisCollege.CourseList){
	    	if(c.acronym.equals("AP")){
	    		String p1="";
	    		String p2="";
	    		for(int tp=0;tp<c.preconditions.length;tp++){
	    			p1+=c.preconditions[tp]+" ";
	    		}
	    		for(int ry=0;ry<c.postconditions.length;ry++){
	    			p2+=c.postconditions[ry]+" ";
	    		}
	    		controller.course.setText(c.name);
	    		controller.prereq.setText(p1);
	    		controller.postreq.setText(p2);
	    		controller.instruct.setText(c.Instructor);
	    		String hy="";
	    		for(int cv=0;cv<c.arr.size();cv++){
	    			hy+=c.arr.get(cv).day+" : "+c.arr.get(cv).start+" - "+c.arr.get(cv).end+"\n";
	    		}
	    		controller.lect.setText(hy);
	    		break;
	    	}
	    }
	    controller.mem=mem;
		Scene scene = new Scene(root);
		 scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
	}
	@FXML
	private void couClick3(ActionEvent event) throws IOException{
		Stage stage = null; 
		Parent root = null; 
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Coursead.fxml"));
	    stage=(Stage) SnS.getScene().getWindow();
	    root = (Parent)fxmlLoader.load();
	    CourseadController controller = fxmlLoader.<CourseadController>getController();
	    for(Course c:mem.thisCollege.CourseList){
	    	if(c.acronym.equals("S&S")){
	    		String p1="";
	    		String p2="";
	    		for(int tp=0;tp<c.preconditions.length;tp++){
	    			p1+=c.preconditions[tp]+" ";
	    		}
	    		for(int ry=0;ry<c.postconditions.length;ry++){
	    			p2+=c.postconditions[ry]+" ";
	    		}
	    		controller.course.setText(c.name);
	    		controller.prereq.setText(p1);
	    		controller.postreq.setText(p2);
	    		controller.instruct.setText(c.Instructor);
	    		String hy="";
	    		for(int cv=0;cv<c.arr.size();cv++){
	    			hy+=c.arr.get(cv).day+" : "+c.arr.get(cv).start+" - "+c.arr.get(cv).end+"\n";
	    		}
	    		controller.lect.setText(hy);
	    		break;
	    	}
	    }
	    controller.mem=mem;
		Scene scene = new Scene(root);
		 scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
	}
	@FXML
	private void couClick4(ActionEvent event) throws IOException{
		Stage stage = null; 
		Parent root = null;
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Coursead.fxml"));
	    stage=(Stage) M3.getScene().getWindow();
	    root = (Parent)fxmlLoader.load();
	    CourseadController controller = fxmlLoader.<CourseadController>getController();
	    for(Course c:mem.thisCollege.CourseList){
	    	if(c.acronym.equals("M-III")){
	    		String p1="";
	    		String p2="";
	    		for(int tp=0;tp<c.preconditions.length;tp++){
	    			p1+=c.preconditions[tp]+" ";
	    		}
	    		for(int ry=0;ry<c.postconditions.length;ry++){
	    			p2+=c.postconditions[ry]+" ";
	    		}
	    		controller.course.setText(c.name);
	    		controller.prereq.setText(p1);
	    		controller.postreq.setText(p2);
	    		controller.instruct.setText(c.Instructor);
	    		String hy="";
	    		for(int cv=0;cv<c.arr.size();cv++){
	    			hy+=c.arr.get(cv).day+" : "+c.arr.get(cv).start+" - "+c.arr.get(cv).end+"\n";
	    		}
	    		controller.lect.setText(hy);
	    		break;
	    	}
	    }
	    controller.mem=mem;
		Scene scene = new Scene(root);
		 scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
	}
	@FXML
	private void couClick5(ActionEvent event) throws IOException{
		Stage stage = null; 
		Parent root = null;
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Coursead.fxml"));
	    stage=(Stage) NT.getScene().getWindow();
	    root = (Parent)fxmlLoader.load();
	    CourseadController controller = fxmlLoader.<CourseadController>getController();
	    for(Course c:mem.thisCollege.CourseList){
	    	if(c.acronym.equals("NT")){
	    		String p1="";
	    		String p2="";
	    		for(int tp=0;tp<c.preconditions.length;tp++){
	    			p1+=c.preconditions[tp]+" ";
	    		}
	    		for(int ry=0;ry<c.postconditions.length;ry++){
	    			p2+=c.postconditions[ry]+" ";
	    		}
	    		controller.course.setText(c.name);
	    		controller.prereq.setText(p1);
	    		controller.postreq.setText(p2);
	    		controller.instruct.setText(c.Instructor);
	    		String hy="";
	    		for(int cv=0;cv<c.arr.size();cv++){
	    			hy+=c.arr.get(cv).day+" : "+c.arr.get(cv).start+" - "+c.arr.get(cv).end+"\n";
	    		}
	    		controller.lect.setText(hy);
	    		break;
	    	}
	    }
	    controller.mem=mem;
		Scene scene = new Scene(root);
		 scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
	}
	@FXML
	private void couClick6(ActionEvent event) throws IOException{
		Stage stage = null; 
		Parent root = null;
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Coursead.fxml"));
	    stage=(Stage) RA.getScene().getWindow();
	    root = (Parent)fxmlLoader.load();
	    CourseadController controller = fxmlLoader.<CourseadController>getController();
	    for(Course c:mem.thisCollege.CourseList){
	    	if(c.acronym.equals("RA")){
	    		String p1="";
	    		String p2="";
	    		for(int tp=0;tp<c.preconditions.length;tp++){
	    			p1+=c.preconditions[tp]+" ";
	    		}
	    		for(int ry=0;ry<c.postconditions.length;ry++){
	    			p2+=c.postconditions[ry]+" ";
	    		}
	    		controller.course.setText(c.name);
	    		controller.prereq.setText(p1);
	    		controller.postreq.setText(p2);
	    		controller.instruct.setText(c.Instructor);
	    		String hy="";
	    		for(int cv=0;cv<c.arr.size();cv++){
	    			hy+=c.arr.get(cv).day+" : "+c.arr.get(cv).start+" - "+c.arr.get(cv).end+"\n";
	    		}
	    		controller.lect.setText(hy);
	    		break;
	    	}
	    }
	    controller.mem=mem;
		Scene scene = new Scene(root);
		 scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
	}
	@FXML
	private void couClick7(ActionEvent event) throws IOException{
		Stage stage = null; 
		Parent root = null; 
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Coursead.fxml"));
	    stage=(Stage) PoK.getScene().getWindow();
	    root = (Parent)fxmlLoader.load();
	    CourseadController controller = fxmlLoader.<CourseadController>getController();
	    for(Course c:mem.thisCollege.CourseList){
	    	if(c.acronym.equals("PoK")){
	    		String p1="";
	    		String p2="";
	    		for(int tp=0;tp<c.preconditions.length;tp++){
	    			p1+=c.preconditions[tp]+" ";
	    		}
	    		for(int ry=0;ry<c.postconditions.length;ry++){
	    			p2+=c.postconditions[ry]+" ";
	    		}
	    		controller.course.setText(c.name);
	    		controller.prereq.setText(p1);
	    		controller.postreq.setText(p2);
	    		controller.instruct.setText(c.Instructor);
	    		String hy="";
	    		for(int cv=0;cv<c.arr.size();cv++){
	    			hy+=c.arr.get(cv).day+" : "+c.arr.get(cv).start+" - "+c.arr.get(cv).end+"\n";
	    		}
	    		controller.lect.setText(hy);
	    		break;
	    	}
	    }
	    controller.mem=mem;
		Scene scene = new Scene(root);
		 scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
	}
	@FXML
	private void couClick8(ActionEvent event) throws IOException{
		Stage stage = null; 
		Parent root = null; 
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Coursead.fxml"));
	    stage=(Stage) Psy.getScene().getWindow();
	    root = (Parent)fxmlLoader.load();
	    CourseadController controller = fxmlLoader.<CourseadController>getController();
	    for(Course c:mem.thisCollege.CourseList){
	    	if(c.acronym.equals("Psy")){
	    		String p1="";
	    		String p2="";
	    		for(int tp=0;tp<c.preconditions.length;tp++){
	    			p1+=c.preconditions[tp]+" ";
	    		}
	    		for(int ry=0;ry<c.postconditions.length;ry++){
	    			p2+=c.postconditions[ry]+" ";
	    		}
	    		controller.course.setText(c.name);
	    		controller.prereq.setText(p1);
	    		controller.postreq.setText(p2);
	    		controller.instruct.setText(c.Instructor);
	    		String hy="";
	    		for(int cv=0;cv<c.arr.size();cv++){
	    			hy+=c.arr.get(cv).day+" : "+c.arr.get(cv).start+" - "+c.arr.get(cv).end+"\n";
	    		}
	    		controller.lect.setText(hy);
	    		break;
	    	}
	    }
	    controller.mem=mem;
		Scene scene = new Scene(root);
		 scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
	}
	@FXML
	private void couClick9(ActionEvent event) throws IOException{
		Stage stage = null; 
		Parent root = null; 
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Coursead.fxml"));
	    stage=(Stage) ISI.getScene().getWindow();
	    root = (Parent)fxmlLoader.load();
	    CourseadController controller = fxmlLoader.<CourseadController>getController();
	    for(Course c:mem.thisCollege.CourseList){
	    	if(c.acronym.equals("ISI")){
	    		String p1="";
	    		String p2="";
	    		for(int tp=0;tp<c.preconditions.length;tp++){
	    			p1+=c.preconditions[tp]+" ";
	    		}
	    		for(int ry=0;ry<c.postconditions.length;ry++){
	    			p2+=c.postconditions[ry]+" ";
	    		}
	    		controller.course.setText(c.name);
	    		controller.prereq.setText(p1);
	    		controller.postreq.setText(p2);
	    		controller.instruct.setText(c.Instructor);
	    		String hy="";
	    		for(int cv=0;cv<c.arr.size();cv++){
	    			hy+=c.arr.get(cv).day+" : "+c.arr.get(cv).start+" - "+c.arr.get(cv).end+"\n";
	    		}
	    		controller.lect.setText(hy);
	    		break;
	    	}
	    }
	    controller.mem=mem;
		Scene scene = new Scene(root);
		 scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
	}
	@FXML
	private void couClick10(ActionEvent event) throws IOException{
		Stage stage = null; 
		Parent root = null;
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Coursead.fxml"));
	    stage=(Stage) IMS.getScene().getWindow();
	    root = (Parent)fxmlLoader.load();
	    CourseadController controller = fxmlLoader.<CourseadController>getController();
	    for(Course c:mem.thisCollege.CourseList){
	    	if(c.acronym.equals("IMS")){
	    		String p1="";
	    		String p2="";
	    		for(int tp=0;tp<c.preconditions.length;tp++){
	    			p1+=c.preconditions[tp]+" ";
	    		}
	    		for(int ry=0;ry<c.postconditions.length;ry++){
	    			p2+=c.postconditions[ry]+" ";
	    		}
	    		controller.course.setText(c.name);
	    		controller.prereq.setText(p1);
	    		controller.postreq.setText(p2);
	    		controller.instruct.setText(c.Instructor);
	    		String hy="";
	    		for(int cv=0;cv<c.arr.size();cv++){
	    			hy+=c.arr.get(cv).day+" : "+c.arr.get(cv).start+" - "+c.arr.get(cv).end+"\n";
	    		}
	    		controller.lect.setText(hy);
	    		break;
	    	}
	    }
	    controller.mem=mem;
		Scene scene = new Scene(root);
		 scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

		stage.setScene(scene);
		stage.show();
	}
	@FXML
	private void couClick11(ActionEvent event) throws IOException{
		Stage stage = null; 
		Parent root = null; 
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Coursead.fxml"));
	    stage=(Stage) IDE.getScene().getWindow();
	    root = (Parent)fxmlLoader.load();
	    CourseadController controller = fxmlLoader.<CourseadController>getController();
	    for(Course c:mem.thisCollege.CourseList){
	    	if(c.acronym.equals("IDE")){
	    		String p1="";
	    		String p2="";
	    		for(int tp=0;tp<c.preconditions.length;tp++){
	    			p1+=c.preconditions[tp]+" ";
	    		}
	    		for(int ry=0;ry<c.postconditions.length;ry++){
	    			p2+=c.postconditions[ry]+" ";
	    		}
	    		controller.course.setText(c.name);
	    		controller.prereq.setText(p1);
	    		controller.postreq.setText(p2);
	    		controller.instruct.setText(c.Instructor);
	    		String hy="";
	    		for(int cv=0;cv<c.arr.size();cv++){
	    			hy+=c.arr.get(cv).day+" : "+c.arr.get(cv).start+" - "+c.arr.get(cv).end+"\n";
	    		}
	    		controller.lect.setText(hy);
	    		break;
	    	}
	    }
	    controller.mem=mem;
		Scene scene = new Scene(root);
		 scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

		stage.setScene(scene);
		stage.show();
	}
	@FXML
	private void couClick12(ActionEvent event) throws IOException{
		Stage stage = null; 
		Parent root = null;
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Coursead.fxml"));
	    stage=(Stage) ES.getScene().getWindow();
	    root = (Parent)fxmlLoader.load();
	    CourseadController controller = fxmlLoader.<CourseadController>getController();
	    for(Course c:mem.thisCollege.CourseList){
	    	if(c.acronym.equals("ES")){
	    		String p1="";
	    		String p2="";
	    		for(int tp=0;tp<c.preconditions.length;tp++){
	    			p1+=c.preconditions[tp]+" ";
	    		}
	    		for(int ry=0;ry<c.postconditions.length;ry++){
	    			p2+=c.postconditions[ry]+" ";
	    		}
	    		controller.course.setText(c.name);
	    		controller.prereq.setText(p1);
	    		controller.postreq.setText(p2);
	    		controller.instruct.setText(c.Instructor);
	    		String hy="";
	    		for(int cv=0;cv<c.arr.size();cv++){
	    			hy+=c.arr.get(cv).day+" : "+c.arr.get(cv).start+" - "+c.arr.get(cv).end+"\n";
	    		}
	    		controller.lect.setText(hy);
	    		break;
	    	}
	    }
	    controller.mem=mem;
		Scene scene = new Scene(root);
		 scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

		stage.setScene(scene);
		stage.show();
	}
	@FXML
	private void couClick13(ActionEvent event) throws IOException{
		Stage stage = null; 
		Parent root = null; 
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Coursead.fxml"));
	    stage=(Stage) TA.getScene().getWindow();
	    root = (Parent)fxmlLoader.load();
	    CourseadController controller = fxmlLoader.<CourseadController>getController();
	    for(Course c:mem.thisCollege.CourseList){
	    	if(c.acronym.equals("TA")){
	    		String p1="";
	    		String p2="";
	    		for(int tp=0;tp<c.preconditions.length;tp++){
	    			p1+=c.preconditions[tp]+" ";
	    		}
	    		for(int ry=0;ry<c.postconditions.length;ry++){
	    			p2+=c.postconditions[ry]+" ";
	    		}
	    		controller.course.setText(c.name);
	    		controller.prereq.setText(p1);
	    		controller.postreq.setText(p2);
	    		controller.instruct.setText(c.Instructor);
	    		String hy="";
	    		for(int cv=0;cv<c.arr.size();cv++){
	    			hy+=c.arr.get(cv).day+" : "+c.arr.get(cv).start+" - "+c.arr.get(cv).end+"\n";
	    		}
	    		controller.lect.setText(hy);
	    		break;
	    	}
	    }
	    controller.mem=mem;
		Scene scene = new Scene(root);
		 scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

		stage.setScene(scene);
		stage.show();
	}
	@FXML
	private void couClick14(ActionEvent event) throws IOException{
		Stage stage = null; 
		Parent root = null; 
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Coursead.fxml"));
	    stage=(Stage) TPEE.getScene().getWindow();
	    root = (Parent)fxmlLoader.load();
	    CourseadController controller = fxmlLoader.<CourseadController>getController();
	    for(Course c:mem.thisCollege.CourseList){
	    	if(c.acronym.equals("TPEE")){
	    		String p1="";
	    		String p2="";
	    		for(int tp=0;tp<c.preconditions.length;tp++){
	    			p1+=c.preconditions[tp]+" ";
	    		}
	    		for(int ry=0;ry<c.postconditions.length;ry++){
	    			p2+=c.postconditions[ry]+" ";
	    		}
	    		controller.course.setText(c.name);
	    		controller.prereq.setText(p1);
	    		controller.postreq.setText(p2);
	    		controller.instruct.setText(c.Instructor);
	    		String hy="";
	    		for(int cv=0;cv<c.arr.size();cv++){
	    			hy+=c.arr.get(cv).day+" : "+c.arr.get(cv).start+" - "+c.arr.get(cv).end+"\n";
	    		}
	    		controller.lect.setText(hy);
	    		break;
	    	}
	    }
	    controller.mem=mem;
		Scene scene = new Scene(root);
		 scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

		stage.setScene(scene);
		stage.show();
	}
	@FXML
	private void couClick15(ActionEvent event) throws IOException{
		Stage stage = null; 
		Parent root = null; 
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Coursead.fxml"));
	    stage=(Stage) PO.getScene().getWindow();
	    root = (Parent)fxmlLoader.load();
	    CourseadController controller = fxmlLoader.<CourseadController>getController();
	    for(Course c:mem.thisCollege.CourseList){
	    	if(c.acronym.equals("PO")){
	    		String p1="";
	    		String p2="";
	    		for(int tp=0;tp<c.preconditions.length;tp++){
	    			p1+=c.preconditions[tp]+" ";
	    		}
	    		for(int ry=0;ry<c.postconditions.length;ry++){
	    			p2+=c.postconditions[ry]+" ";
	    		}
	    		controller.course.setText(c.name);
	    		controller.prereq.setText(p1);
	    		controller.postreq.setText(p2);
	    		controller.instruct.setText(c.Instructor);
	    		String hy="";
	    		for(int cv=0;cv<c.arr.size();cv++){
	    			hy+=c.arr.get(cv).day+" : "+c.arr.get(cv).start+" - "+c.arr.get(cv).end+"\n";
	    		}
	    		controller.lect.setText(hy);
	    		break;
	    	}
	    }
	    controller.mem=mem;
		Scene scene = new Scene(root);
		 scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

		stage.setScene(scene);
		stage.show();
	}
}

