package application;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
/**
 * <p> Class for College in our application . Stores all the information (MemberList , CourseList, RoomList) about the college </p>
 * @author anush
 *
 */
public class College implements Serializable {

	public List<Member> MemberList;
	public List<Admin> adminList;
	public List<Faculty> FacultyList;
	public List<Student> StudentList;
	public List<Request> RequestList;
	public List<Course> CourseList;
	public List<event> events;
	public List<Room> rooms;
	public HashSet<String> emails;
	public HashMap<String,event> hashmap;
	//public HashMap<String,HashMap<String,>>;
	
	public College(){
		MemberList=new ArrayList<Member>();
		adminList=new ArrayList<Admin>();
		FacultyList=new ArrayList<Faculty>();
		StudentList=new ArrayList<Student>();
		RequestList=new ArrayList<Request>();
		CourseList=new ArrayList<Course>();
		events=new ArrayList<event>();
		rooms=new ArrayList<Room>();
		hashmap=new HashMap<String,event>();
		emails=new HashSet<String>();
	}
	public Room getRoom(String n1){
		for(Room w:rooms){
			if(w.Room_number.equals(n1)){
				return w;
			}
		}
		Room sd=new Room(n1,this);
		return sd;
	}
	public boolean isroom(String n1){
		for(Room w:rooms){
			if(w.Room_number.equals(n1)){
				return true;
			}
		}
		return false;
	}
	public	void	serialize()	throws	IOException	{

		ObjectOutputStream out	=	null;	
		try	{	
			out	=	new	ObjectOutputStream	(new FileOutputStream("Admin/"+"IIITD"+".txt"));	
			out.writeObject(this);	
		}	
		finally
		{	
			out.close();	
		}
	}
	public static	 College deserialize() throws	IOException,	ClassNotFoundException {
		ObjectInputStream	in	=	null;	
	try	{	
		
		String fo="Admin/"+"IIITD.txt";
		in	=		new	ObjectInputStream	(	new	FileInputStream(fo));	
		College	s1	=	(College)	in.readObject();
		
		return s1;

	}	finally	{	
		in.close();	
	}	
	}
	
	public List<Member> getMemberList() {
		return MemberList;
	}
	public void setMemberList(List<Member> memberList) {
		MemberList = memberList;
	}
	public List<Admin> getAdminList() {
		return adminList;
	}
	public void setAdminList(List<Admin> adminList) {
		this.adminList = adminList;
	}
	public List<Faculty> getFacultyList() {
		return FacultyList;
	}
	public void setFacultyList(List<Faculty> facultyList) {
		FacultyList = facultyList;
	}
	public List<Request> getRequestList() {
		return RequestList;
	}
	public void setRequestList(List<Request> requestList) {
		RequestList = requestList;
	}
	
	
	




	
}
