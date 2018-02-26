package application;

import java.io.Serializable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * <p> Manages the event associated with the Course ie the day of the class the timings and other fetaures</p>
 * @author Snehal 
 *
 */
class event implements Serializable{
	String day;
	String start;
	String end;
	List<Room> venue;
	
	
	public event(String n1,String n2,String n3,List<Room> n4){
		day=n1;
		start=n2.replace(":", "");
		if(Integer.parseInt(start)<800)
		{
			int g=Integer.parseInt(start)+1200;
			start=Integer.toString(g);
		}
		end=n3.replace(":", "");
		if(Integer.parseInt(end)<800)
		{
			int g=Integer.parseInt(end)+1200;
			end=Integer.toString(g);
		}
		venue=n4;
	}
	
	public String toString(){
		String ans=start+"-"+end+" ";
		for(int y=0;y<venue.size();y++){
			ans+=venue.get(0).Room_number+",";
		}
		return ans;
	}
}
/**
 * <p> this implements serializable, Course class stores the info about the courses , Instructor of the course, Credits associated with the course, acronym of the courseetc </p>
 * @author Snehal
 *
 */
public class Course implements Serializable {
	
	
	public College college;
	
	
	
public String ismandatory;
public String name;
public String Code;
public String Instructor;
public int credits;
public final String acronym;
public 	ArrayList<event> arr ;
public String[] preconditions;
public String[] postconditions;
public int audience;

public Course(String n1,String n2,String n3,String n4,int n5,String n6,ArrayList<event> n7,String[] n8,String[] n9){
	ismandatory=n1;
	name=n2;
	Code=n3;
	Instructor=n4;
	credits=n5;
	acronym=n6;
	arr=n7;
	preconditions=n8;
	postconditions=n9;
	audience=200;
}

public String toString(){
	String ans=" ";
	//String sd=ismandatory+" "+name+" "+Code+" "+Instructor+" "+credits+" "+acronym+"\n"+arr.size();
	String zx="";
	System.out.println(name);
	for(int i=0;i<arr.size();i++){
		zx+=arr.get(i).toString()+"\n";
	}
	ans=zx;
	return ans;
}
public boolean findkeyword(String tomatch)
{
	/*for(String find : preconditions)
	{
		if(find.equals(tomatch))
		{
			return true;
		}
	}*/
	//System.out.println("LABOOOOOOOOOOOOOOOO");
	for(String find : postconditions)
	{
		//System.out.print(find+" ");
		if(find.equals(tomatch))
		{
			System.out.println("jingalahuhu");
			return true;
		}
	}
	
	return false;
}

public	void	serialize(Course s1)	throws	IOException	{
	
	ObjectOutputStream out	=	null;	
	try	{	
		out	=	new	ObjectOutputStream	(new FileOutputStream("Course/"+".txt"));	
		out.writeObject(s1);	
		}	
	finally
	{	
			out.close();	
		}
		}
public		Course deserialize(String u) throws	IOException,	ClassNotFoundException {ObjectInputStream	in	=	null;	
								try	{	
									String fo="Course/"+u;
								in	=		new	ObjectInputStream	(	new	FileInputStream(fo));	
												Course	s1	=	(Course)	in.readObject();		
												return s1;

								}	finally	{	
												in.close();	
								}	
				}





public int getAudience() {
	return audience;
}
public void setAudience(int audience) {
	this.audience = audience;
}
public String[] getPostconditions() {
	return postconditions;
}
public void setPostconditions(String[] postconditions) {
	this.postconditions = postconditions;
}
public String[] getPreconditions() {
	return preconditions;
}
public void setPreconditions(String[] preconditions) {
	this.preconditions = preconditions;
}

public static Course getInstance(String ismandatory2, String name2, String code2, String instructor2, int credits2,
		String acronym2, ArrayList<event> arr2, String[] precw, String[] postw, College college) {
	Course roo=null;
	int flag=0;
	for(Course r:college.CourseList)
	{
		if(r.acronym.equals(acronym2)) {
			roo=r;
			flag=1;
			break;
		}
	}
	if(flag==0)
	{
		roo=new Course(ismandatory2,name2,code2,instructor2,credits2,acronym2,arr2,precw,postw);
	}
	
	
	return roo;

	
	
	// TODO Auto-generated method stub
}

}
