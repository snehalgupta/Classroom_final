package application;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
/**
 * 
 * <h1> Student Class </h1>
 * <p> This class Student extends Member Class with its own requestList . The objects created in this class is serializable </p>
 * @author Anushka Bhandari
 * @author Snehal Gupta
 * @version 1.0
 * @since November 11, 2017
 *
 *
 *
 *
 */
public class Student extends Member{
		/**
	 * 
	 * <p> Constructor instantiates Student object with a college , a name , an email and a password which are all the attributes in Member Class  </p>
	 *
	 *
	 *
	 *
	 *
	 */
	public Student(College thisCollege, String name, String email, String password) {
		super(thisCollege, name, email, password);
		TimeTable=new ArrayList<Course>();
		MY_Req=new ArrayList<Request>();
		// TODO Auto-generated constructor stub
	}
	public List<Course> TimeTable;
	public  List<Request> MY_Req;
/**
	*
	* <p> Method that is used to search for a Course the student adds. </p>
	* <p> it looks for whether it clashes with the existing timetabl of the student or not</p>
	*
	*/
	public boolean search(Course st) {
		for(Course v:TimeTable){
			for(event e1 : v.arr){
				for(event e2 : st.arr){
					int e2sta=Integer.parseInt(e2.start);
					int e1end=Integer.parseInt(e1.end);
					int e2end=Integer.parseInt(e2.end);
					int e1sta=Integer.parseInt(e1.start);
					//System.out.println(e2sta+" "+e2end+" "+e1sta+" "+e1end);
					if((e2sta<e1end && e2sta>e1sta) || (e2end<e1end && e2end>e1sta) || (e2end==e1end ||e2sta==e1sta)){
						return true;
					}
				}
			}
			}
		return false;
	}
	/**
 * Course a is added to the TimeTable of the Student
 * @param a
 */
	public void addCourse(Course a) {
		TimeTable.add(a);

	

	}
	/**
 *<p> the Course is dropped from the timetable </p>
 * @param a
 */
	public void dropCourse(Course a){
		TimeTable.remove(a);
	}
	public Request Booking() {
		return null;

	}

	/**
 * <p>getter function for  TimeTable of the Student</p>
 * @param TimeTable
 */
	public List<Course> getTimeTable() {
		return TimeTable;
	}

/**
 * <p>setter function for  TimeTable of the Student</p>
 * @param TimeTable
 */
	public void setTimeTable(List<Course> timeTable) {
		TimeTable = timeTable;
	}

	/**
	 * <p>getter function for MyReq Requests lists</p>
	 * @param mY_Req
	 */
	public List<Request> getMY_Req() {
		return MY_Req;
	}
/**
 *<p> setter function for MyReq Requests lists</p>
 * @param mY_Req
 */
	public void setMY_Req(List<Request> mY_Req) {
		MY_Req = mY_Req;
	}
	/**
	*
	* <p> Method that is used to create serialisable objects. </p>
	* @throws IOException If an input or output exception occurs.
	*
	*
	*/
	public	void	serialize()	throws	IOException	{

		ObjectOutputStream out	=	null;	
		try	{	
			out	=	new	ObjectOutputStream	(new FileOutputStream("Student/"+this.Name+".txt"));	
			out.writeObject(this);	
		}	
		finally
		{	
			out.close();	
		}
	}
	 /**
	*
	* <p> Method used to deserialise the Student object. </p>
	* @throws IOException If an input or output exception occured
	* @throws ClassNotFoundException
	*
	*/
	public	static	Student deserialize(String u) throws	IOException,	ClassNotFoundException {ObjectInputStream	in	=	null;	
	try	{	
		String fo="Student/"+u;
		in	=		new	ObjectInputStream	(	new	FileInputStream(fo));	
		Student	s1	=	(Student)	in.readObject();		
		return s1;

	}	finally	{	
		in.close();	
	}	
	}
//
	


}

