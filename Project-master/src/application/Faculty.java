package application;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Faculty extends Member implements Serializable {
	public Faculty(College thisCollege,String name, String email, String password) {
		super(thisCollege, name,email, password);
		System.out.println("timetable created");
		TimeTable=new ArrayList<Course>();
		// TODO Auto-generated constructor stub
	}
	public List<Course> TimeTable;
	@Override
		public	void	serialize()	throws	IOException	{
		
		ObjectOutputStream out	=	null;	
		try	{	
			out	=	new	ObjectOutputStream	(new FileOutputStream("Faculty/"+this.Name+".txt"));	
			out.writeObject(this);	
			}	
		finally
		{	
				out.close();	
			}
			}
	public		Faculty deserialize(String u) throws	IOException,	ClassNotFoundException {ObjectInputStream	in	=	null;	
									try	{	
										String fo="Faculty/"+u;
									in	=		new	ObjectInputStream	(	new	FileInputStream(fo));	
													Faculty	s1	=	(Faculty)	in.readObject();		
													return s1;

									}	finally	{	
													in.close();	
									}	
					}

}
