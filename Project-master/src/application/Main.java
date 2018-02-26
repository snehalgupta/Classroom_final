package application;



import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;

import com.opencsv.CSVReader;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.*;

import javafx.stage.Stage;


/**
 * 
 * <h1> Main Class </h1>
 * <p> This class is the Main Class which runs to run our application . It extends Application and starts with the stage set to HomePageController  </p>
 * <p> All the Controller classes associated with HomePage.fxml are using style.css </p>
 *  @throws IOException If an input or output exception occurs.
 *  @author Anushka Bhandari
 * @author Snehal Gupta
 * @version 1.0
 * @since November 11, 2017
 */
public class Main extends Application {
	public static College college;
	@Override

	public void start(Stage primaryStage) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("HomePage.fxml"));
		AnchorPane rootLayout = (AnchorPane) fxmlLoader.load();
		HomePageController controller = fxmlLoader.<HomePageController>getController();
		controller.college=college;

		// Show the scene containing the root layout.
		Scene scene = new Scene(rootLayout);
	    scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setOnCloseRequest(event -> {
			System.out.println("Stage is closing");
			try {
				college.serialize();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// Save file
		});




	}
/**<p> The Main method in Main class is creating all the objects from reading the sample.csv database using opencsv package</p>
	 *  <p> Once the database is read , user interacts with that data and upon closing the application ,the changes there are stored via serialization. </p>
	 * <p>The changes are reflected back via deserialization    </p>
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
	public static void main(String[] args) {




		try 
		{

			BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
			int Value =0;
			System.out.println("Start dhinchak");
			System.out.println("Enter 1 for databse");
			System.out.println("Enter 2 for prev session");
			System.out.println("value is "+Value);
			Value=Integer.parseInt(reader.readLine());
			System.out.println("value is "+Value);
			if(Value==1)
			{
				/**
				 * LOAD FROM DATABASE
				 */
				System.out.println("LOADING");
				college=new College();
				//ArrayList<Course> CourseList = new ArrayList<Course>();
				String csvFilename = "./src/Sample.csv";
				CSVReader csvReader = new CSVReader(new FileReader(csvFilename));
				String[] row = null;
				String day;
				String start=" ";
				String temp;
				String end=" ";
				String room;
				String ismandatory;
				String name;
				String Code;
				String Instructor;
				int credits;
				String acronym;
				ArrayList<String> days=new ArrayList<String>();
				days.add("Mon");
				days.add("Tue");
				days.add("Wed");
				days.add("Thu");
				days.add("Fri");
				ArrayList<event> arr=new ArrayList<event>() ;
				List<Room> roo=new ArrayList<Room>();
				row=csvReader.readNext();
				while((row = csvReader.readNext()) != null) {
					int py=0;
					ismandatory=row[0];
					name=row[1];
					Code=row[2];
					Instructor=row[3];
					credits=Integer.parseInt(row[4]);
					acronym=row[5];
					//System.out.println(name);
					for(int ey=6;ey<=10;ey++){
					temp=row[ey];
					int idx=0;
					if(temp.length()>0){
					for(int x=0;x<temp.length();x++){
						if(temp.charAt(x) == '-'){
							start=temp.substring(0,x);
							idx=x+1;
						}
						if(temp.charAt(x) == '$'){
							end=temp.substring(idx,x);
							if(college.isroom(temp.substring(x+1))){
								Room ds=college.getRoom(temp.substring(x+1));
								roo.add(ds);
							}
							else{
							Room r1=new Room(temp.substring(x+1),college);
							roo.add(r1);
							college.rooms.add(r1);}
						}
					}
					event e1=new event(days.get(py),start,end,roo);
					college.events.add(e1);
					arr.add(e1);}
					//System.out.println("here1");
					/*if(roo.size()>0){
						System.out.println(roo.get(0).Room_number);
					}*/
					py+=1;
					//arr.add(e1);
					roo=new ArrayList<Room>();
					}
					String[] arq=row[11].split(" : ");
					if(row[11].length()>0){
					for(int j1=0;j1<arq.length;j1++){
						//System.out.println(arq[j1]);
						int co= 0;
						String dayz=" ";
						String startz=" ";
						String endz=" ";
						int endindex=0;
						int sez=0;
						int findi=0;
						ArrayList<Room> rooz=new ArrayList<Room>();
						for(int j2=0;j2<arq[j1].length();j2++){
							if(arq[j1].charAt(j2)=='$'){
								//System.out.println("yes");
								co+=1;
								if(co == 1){
									dayz=arq[j1].substring(0,j2-1);
									dayz=dayz.substring(0,3);
									endindex=j2;
								}
								else if(co == 2){
									sez=j2;
									for(int iz=endindex+1;iz<j2;iz++){
										if(arq[j1].charAt(iz) == '-'){
											startz=arq[j1].substring(endindex+1,iz);
											endz=arq[j1].substring(iz+1,j2);
										}
									}
								}
							}
							else if(co == 2){
								co=1;
								int ecz=j2-1;
								for(int yuz=j2;yuz<arq[j1].length();yuz++){
									
									if(arq[j1].charAt(yuz) == ';'){
										if(college.isroom(arq[j1].substring(ecz+1,yuz))){
											Room ds=college.getRoom(arq[j1].substring(ecz+1,yuz));
											rooz.add(ds);
										}
										else{
										Room r1=new Room(arq[j1].substring(ecz+1,yuz),college);
										rooz.add(r1);
										college.rooms.add(r1);}
										ecz=yuz;
										endindex=yuz;
									}
								}
							}
						}
						event e2=new event(dayz,startz,endz,rooz);
						/*System.out.println(dayz+" "+startz+" "+endz);
						for(int iu=0;iu<rooz.size();iu++){
							System.out.print(rooz.get(iu).Room_number+" ");
						}
						System.out.println();*/
						arr.add(e2);
						college.events.add(e2);
						//System.out.println("here2");
					}
					}
						int co= 0;
						String dayz=" ";
						String startz=" ";
						String endz=" ";
						int endindex=0;
						int sez=0;
						int findi=0;
						ArrayList<Room> rooz=new ArrayList<Room>();
						for(int j2=0;j2<row[12].length();j2++){
							if(row[12].charAt(j2)=='$'){
								//System.out.println("yes");
								co+=1;
								if(co == 1){
									dayz=row[12].substring(0,j2-1);
									dayz=dayz.substring(0,3);
									endindex=j2;
								}
								else if(co == 2){
									sez=j2;
									for(int iz=endindex+1;iz<j2;iz++){
										if(row[12].charAt(iz) == '-'){
											startz=row[12].substring(endindex+1,iz);
											endz=row[12].substring(iz+1,j2);
										}
									}
								}
							}
							else if(co == 2){
								co=1;
								int ecz=j2-1;
								for(int yuz=j2;yuz<row[12].length();yuz++){
									
									if(row[12].charAt(yuz) == ';'){
										
										if(college.isroom(row[12].substring(ecz+1,yuz))){
											Room ds=college.getRoom(row[12].substring(ecz+1,yuz));
											rooz.add(ds);
										}
										else{
										Room r1=new Room(row[12].substring(ecz+1,yuz),college);
										rooz.add(r1);
										college.rooms.add(r1);}
										ecz=yuz;
										endindex=yuz;
									}
								}
							}
						}
						if(row[12].length()>0){
						event e2=new event(dayz,startz,endz,rooz);
						/*System.out.println(dayz+" "+startz+" "+endz);
						for(int iu=0;iu<rooz.size();iu++){
							System.out.print(rooz.get(iu).Room_number+" ");
						}
						System.out.println();*/
						college.events.add(e2);
						arr.add(e2);}
						//System.out.println("herer3");
						String[] precw=row[13].split(" ");
						String[] postw=row[14].split(" ");
						/*if(precw.length>0){
							System.out.println(precw[0]);
						}
						if(postw.length>0){
							System.out.println(postw[0]);
						}*/
						Course c1=new Course(ismandatory,name,Code,Instructor,credits,acronym,arr,precw,postw);
						college.CourseList.add(c1);
						arr=new ArrayList<event>();
				}
				csvReader.close();
				System.out.println("HULAA");
				
				for(int io=0;io<college.CourseList.size();io++){
					System.out.println(college.CourseList.get(io));
				}
				for(int yu=0;yu<college.rooms.size();yu++){
					System.out.println("Room : "+college.rooms.get(yu).Room_number);
				}
				
				for(int x=0;x<college.rooms.size();x++){
					for(int y=0;y<college.events.size();y++){
						
					}
				}

				for(Room r:college.rooms) {
					r.init();
				}


				//				public List<Member> MemberList;
				//				public List<Admin> adminList;
				//				public List<Faculty> FacultyList;
				//				public List<Student> StudentList;
				//				public List<Request> RequestList;
				//				public List<Course> CourseList;
				//				public List<event> events;
				//				public List<Room> rooms;
				//				public HashSet<String> emails;
				//				public HashMap<String,event> hashmap;
				for(Course a:college.CourseList) 
				{
					for(event e:a.arr) {
						for(Room r:e.venue) 
						{
							try {
								r.MAPPED.get(e.day).put(e.start+"-"+e.end, a);
							}

							catch(NullPointerException p)
							{
								r.MAPPED.put(e.day, new HashMap<String,Course>() );
								r.MAPPED.get(e.day).put(e.start+"-"+e.end, a);

								//System.out.println(e.day+" "+r.MAPPED.get(e.day)+"ljn");
							}
						}
					}
				}



				for(Room a: college.rooms)
				{

					System.out.println(a.Room_number+" ");
					for(Entry<String,HashMap<String, Course>> e:a.MAPPED.entrySet()) 
					{

						System.out.println(e.getKey()+" ");

						for(Entry<String,Course> f:e.getValue().entrySet()) {
							System.out.print(f.getKey()+" "+f.getValue().acronym);
						}
					}





				}
				/*HashMap<Room,Boolean> b=Room.okay("1100-1200","Sun","",college);

				for(Entry<Room,Boolean> f:b.entrySet()) {
					System.out.println(f.getKey().Room_number+" "+f.getValue());
				}*/
//				Request req=new  Request( "MAA", college.getRoom("C01"),  100, 3, true) ;
//		    	req.serialize();
//		    	Request sq=Request.deserialize();
//		    	System.out.println(sq);



		    	college.getRoom("C01").Capacity=100;

		    	college.getRoom("C02").Capacity=40;
		    	college.getRoom("C03").Capacity=45;
		    	college.getRoom("C11").Capacity=127;
		    	college.getRoom("C12").Capacity=40;
		    	college.getRoom("C13").Capacity=65;
		    	college.getRoom("C21").Capacity=150;
		    	college.getRoom("C22").Capacity=48;
		    	college.getRoom("C23").Capacity=50;
		    	college.getRoom("C24").Capacity=60;
		    	college.getRoom("S01").Capacity=39;
		    	college.getRoom("S02").Capacity=50;
		    	college.getRoom("LR1").Capacity=45;
		    	college.getRoom("LR2").Capacity=45;
		    	college.getRoom("LR3").Capacity=45;
		    	college.getRoom("L21").Capacity=50;

		    	college.getRoom("L22").Capacity=50;
		    	college.getRoom("L23").Capacity=40;






			}
			else if(Value==2)
			{
				System.out.println("DESERIALIZE");

				try {
					//File CollegeFile= new File("College.txt");
					/*{
						//College
						currCollege=College.deserialize();
					}*/
					college=College.deserialize();
					for(Course c:college.CourseList) {
						System.out.println(c.acronym+" ");
					}
					for(Member ci:college.MemberList) {
						System.out.println(ci.Name+" ");
					}
					for(Request re:college.RequestList)
					{
						System.out.println(re.toString()+" p");
					}					//Student

					for(Room r:college.rooms)
					{
						System.out.println(r.Room_number+" p");
					}					//Student
			    	college.getRoom("C01").Capacity=100;

			    	college.getRoom("C02").Capacity=40;
			    	college.getRoom("C03").Capacity=45;
			    	college.getRoom("C11").Capacity=127;
			    	college.getRoom("C12").Capacity=40;
			    	college.getRoom("C13").Capacity=65;
			    	college.getRoom("C21").Capacity=150;
			    	college.getRoom("C22").Capacity=48;
			    	college.getRoom("C23").Capacity=50;
			    	college.getRoom("C24").Capacity=60;
			    	college.getRoom("S01").Capacity=39;
			    	college.getRoom("S02").Capacity=50;
			    	college.getRoom("LR1").Capacity=45;
			    	college.getRoom("LR2").Capacity=45;
			    	college.getRoom("LR3").Capacity=45;
			    	college.getRoom("L21").Capacity=50;

			    	college.getRoom("L22").Capacity=50;
			    	college.getRoom("L23").Capacity=40;

					/*File StudentFile= new File("Student/");
						for(String s :StudentFile.list())
						{
						StudentList.add(Student.deserialize(s));
						}*/

					/*File RoomFile= new File("Room/");
						for(String s :RoomFile.list())
						{Room des=Room.deserialize(s);
						RoomList.add(des);
						//System.out.println(des.Room_number);
						}*/
					/*File CourseFile= new File("Course/");
						for(String s :CourseFile.list())
						{
						CourseList.add(Course.deserialize(s));
						}
						File FacultyFile= new File("Faculty/");
						for(String s :FacultyFile.list())
						{
						FacultyList.add(Faculty.deserialize(s));
						}*/
					/*File AdminFile= new File("Admin/");
						for(String s :AdminFile.list())
						{ System.out.println(s);
							Admin as=Admin.deserialize(s);
							System.out.println(as.email+" "+as.Name);
						college.adminList.add(as);
						}*/
					/*File RequestFile= new File("Request/");
						for(String s :RequestFile.list())
						{
						RequestList.add(Request.deserialize(s));
						}*/

					//String[] arrr=reader.readLine().split(" ");






				}
				catch(Exception e)
				{
					e.printStackTrace();
				}

			}

		}catch(Exception e) {
			e.printStackTrace();
		}






		launch(args);
	}
}
