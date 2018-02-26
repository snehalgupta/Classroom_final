package application;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;
/**
 * <p> Request Class handles the request by Memebers in the college </p>
 * <p> It manages the attributes such as purpose of the request, date, timeslot etc </p>
 * @author anush
 *
 */
public class Request implements Serializable {
public String purpose;
public Room prefered_room;
public String date;
public String timeslot;
public int Capacity;
public final Date timeofBooking;
public int status;
public int pending;
public Member m;

public Request(String purpose, Room prefered_room, int capacity,Member a,String da,String timeslot) {
	//System.out.println("kjbnjoibkbn");
	this.purpose = purpose;
	this.prefered_room = prefered_room;
	
	Capacity = capacity;
	if(Capacity>prefered_room.Capacity)
	{
		this.status=-1;
	}
	this.timeofBooking = new Date();
	this.status = 0;
	this.date=da;
    Date date = new Date();  
    this.timeslot=timeslot;
    m=a;
    


	//1- for acceptd
	//0 Remaining
	//-1 for rejected
}

public int getpending() {
    Date date = new Date();  

    pending = (int) ((date.getTime() - timeofBooking.getTime()) / (1000 * 60 * 60 * 24));

	return pending;
}
@Override
	public String toString() {
		return this.prefered_room.Room_number+ " "+this.m.Name+" "+this.m.getClass().getSimpleName()+" time of booking=>"+this.timeofBooking+ " timeslot "+timeslot+"c         "+purpose + purpose+", Capacity=" + Capacity+ ", pending_days=" + this.getpending() + ", status=" + status + "]";
	}

public String getPurpose() {
	return purpose;
}
public void setPurpose(String purpose) {
	this.purpose = purpose;
}
public Room getPrefered_room() {
	return prefered_room;
}
public void setPrefered_room(Room prefered_room) {
	this.prefered_room = prefered_room;
}
public int getCapacity() {
	return Capacity;
}
public void setCapacity(int capacity) {
	Capacity = capacity;
}




public	void	serialize()	throws	IOException	{
	
ObjectOutputStream out	=	null;	
try	{	
		out	=	new	ObjectOutputStream	(new FileOutputStream(this.purpose+".txt"));	
		out.writeObject(this);	
		}	
	finally
	{	
			out.close();	
		}
		}
public	static	Request deserialize() throws	IOException,	ClassNotFoundException {ObjectInputStream	in	=	null;	
								try	{	
									String fo="MAA.txt";
								in	=		new	ObjectInputStream	(	new	FileInputStream(fo));	
												Request	s1	=	(Request)	in.readObject();		
												return s1;

								}	finally	{	
												in.close();	
								}	
				}




















}
