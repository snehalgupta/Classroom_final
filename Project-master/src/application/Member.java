package application;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/**
 * 
 * <h1> Member Class </h1>
 * <p> This class Member is for instantiating any member object in the application. The objects created in this class is serializable </p>
 * <p> It has attributes Name, MyBookings<Request List> M, a college, an email and a password </p>

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

public abstract class Member implements Serializable {
	public College thisCollege;
	public List<Request> MyBookings;
	
	public String Name;
	/**
	 * 
	 * <h1> Member Class </h1>
	 * <p> This constructor instantiates a Member . </p>
	 * <p> With the attributes Name, MyBookings<Request List> M, a college, an email and a password </p>
	 */
	public Member(College thisCollege,String name, String email, String password) {
		super();
		this.thisCollege = thisCollege;
		MyBookings = new ArrayList<Request>();
		Name = name;
		this.email = email;
		this.password = password;
	}
	
	public String email;
	public String password;
	/**
	 * Simple getter for email
	 * @return
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * Simple setter for email
	 * @return
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * Simple getter for password
	 * @return
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * Simple setter for password
	 * @return
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	public void serialize() throws IOException {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
}






