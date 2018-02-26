package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
/**
 * 
 * <h1> Admin Class </h1>
 * <p> This class Admin extends Member Class with its own requestList . The objects created in this class is serializable </p>
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
public class Admin extends Member{
	
public  ArrayList<Request> reqlist=new ArrayList<>();
/**
 * 
 * <p> Constructor instantiates Admin object with a college , a name , an email and a password which are all the attributes in Member Class  </p>
 *
 *
 *
 *
 *
 */

	public Admin(College thisCollege, String name, String email, String password) {
		super(thisCollege, name, email, password);
		// TODO Auto-generated constructor stub
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
			out	=	new	ObjectOutputStream	(new FileOutputStream("Admin/"+this.Name+".txt"));	
			out.writeObject(this);	
		}	
		finally
		{	
			out.close();	
		}
	}
	 /**
		*
		* <p> Method used to deserialise the Admin object. </p>
		* @throws FileNotFoundException
		* @throws IOException If an input or output exception occured
		* @throws ClassNotFoundException
		*
		*/
	public		Admin deserialize(String u) throws	IOException,	ClassNotFoundException,FileNotFoundException {ObjectInputStream	in	=	null;	
	try	{	
		String fo="Admin/"+u;
		in	=		new	ObjectInputStream	(	new	FileInputStream(fo));	
		Admin	s1	=	(Admin)	in.readObject();		
		return s1;

	}	finally	{	
		in.close();	
	}	
	}



}
