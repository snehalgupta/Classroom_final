package application;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
/**
 * <p> Room class implements the serializable function and handles the availabiltiy of the Room and its capacity and other functions associated with it</p>
 * @author anush
 *
 */
public class Room implements Serializable {



	public   College College;
	public  boolean availabilty;
	public String Room_number;
	public  int Capacity;

	public HashMap<String,HashMap<String,Course>> MAPPED;
	HashMap<String,ArrayList<String>> Booking=new HashMap<String,ArrayList<String>>();
	public void book(String date,String Str) {
		if(!this.Booking.containsKey(date))
		{ArrayList<String> lol=new ArrayList<String>();
		lol.add(Str);
		this.Booking.put(date, lol);

		}
		else {
			this.Booking.get(date).add(Str);
		}
	}
	//Monday -- 1030-1130-AP
	//		--1100-1430-PoK
	//		-- 1030-1130-AP
	//		-- 1030-1130-AP
	//Tuesday -- 0945-9087-AP
	//
	//Monday -- 1030-1130-AP
	//Monday -- 1030-1130-AP

	public static  HashMap<Room, Boolean> okay(String timeslot,String day,String date,College College)
	{//timeslot format 1114-1520
		HashMap<Room,Boolean> avail = new HashMap<Room,Boolean>();
		String[] str=timeslot.split("-");
		int begin=Integer.parseInt(str[0]);
		int end=Integer.parseInt(str[1]);

		{
			//System.out.println(College.toString());
			//true is availbale
			for(Room r:College.rooms)
			{
				boolean h=true;

				HashMap<String,Course> timemap=r.MAPPED.get(day);
				//System.out.println(r.Room_number+" ");
				for(Entry<String, Course> e:timemap.entrySet()) 
				{

					String[] str1=e.getKey().split("-");
					int start=Integer.parseInt(str1[0]);
					int finish=Integer.parseInt(str1[1]);
					//System.out.println("BEGIN "+ begin+ "END "+ end+" "+"START"+start+"FINISH "+finish);

					//START begin end FINISH
					//System.out.print(e.getKey()+" ");
					if(start<=begin && end<finish)
					{
						System.out.println("pehla");
						h=false;
						System.out.println(r.Room_number+" "+h);

						break;
					}
					//	START begin  FINISH  end
					//1000 1100 1100 12000
					//830 1100  1000 1200

					else if(start<=begin&&end>finish &&begin<finish)
					{
						System.out.println("dusra");


						h=false;
						System.out.println(r.Room_number+" "+h);

						break;

					}
					//830 -1000
					//	 begin START FINISH  end

					else if(begin<=start &&finish <=end) 
					{
						System.out.println("tessra");

						h=false;
						System.out.println(r.Room_number+" "+h);

						break;

					}
					else if(begin<=start && end<=finish &&start<end) 
					{
						System.out.println("choutha");

						h=false;
						System.out.println(r.Room_number+" "+h);

						break;
					}
					//	"1407-1507"
				}
				avail.put(r, h);
			}
			if(!date.equals(""))
			{			
				for(Entry<Room,Boolean> lol:avail.entrySet())
				{
					if(lol.getValue().equals(true))
					{
						HashMap<String, ArrayList<String>> mai=lol.getKey().Booking;
						if(mai.containsKey(date)) 
						{
							for(String s:mai.get(date)) 
							{
								String[] str1=s.split("-");
								int start=Integer.parseInt(str1[0]);
								int finish=Integer.parseInt(str1[1]);
								if(start<=begin && end<finish)
								{
									System.out.println("pehla");

									lol.setValue(false);
									break;
								}
								//	START begin  FINISH  end
								//1000 1100 1100 12000
								//830 1100  1000 1200

								else if(start<=begin&&end>finish &&begin<finish)
								{
									System.out.println("dusra");
									lol.setValue(false);								
									break;

								}
								//830 -1000
								//	 begin START FINISH  end

								else if(begin<=start &&finish <=end) 
								{
									System.out.println("tessra");
									lol.setValue(false);
									break;

								}
								else if(begin<=start && end<=finish &&start<end) 
								{
									System.out.println("choutha");
									lol.setValue(false);									
									break;
								}

							}
						}

					}
				}
			}





			return avail;
		}

	}



	@Override
	public String toString() {
		return "Room [College=" + College + ", availabilty=" + availabilty + ", Room_number=" + Room_number
				+ ", Capacity=" + Capacity + ", MAPPED=" + MAPPED + ", Booking=" + Booking + "]";
	}

	public Room(String n1,College c){
		Room_number=n1;
		College=c;

	}
	public void init() {
		MAPPED=new HashMap<String,HashMap<String,Course>>();
		MAPPED.put("Mon", new HashMap<String,Course>() );
		MAPPED.put("Tue", new HashMap<String,Course>());
		MAPPED.put("Wed", new HashMap<String,Course>());
		MAPPED.put("Thu", new HashMap<String,Course>());
		MAPPED.put("Sun", new HashMap<String,Course>() );
		MAPPED.put("Sat", new HashMap<String,Course>() );

		MAPPED.put("Fri", new HashMap<String,Course>());

	}
	public HashMap<String, HashMap<String, Course>> getMAPPED() {
		return MAPPED;
	}
	public void setMAPPED(HashMap<String, HashMap<String, Course>> mAPPED) {
		MAPPED = mAPPED;
	}
	public boolean isAvailabilty() {
		return availabilty;
	}
	public void setAvailabilty(boolean availabilty) {
		this.availabilty = availabilty;
	}
	public String getRoom_number() {
		return Room_number;
	}
	public int getCapacity() {
		return Capacity;
	}
	public void setCapacity(int capacity) {
		Capacity = capacity;
	}
	public Room(boolean availabilty, String room_number, int capacity,College c) {
		super();
		this.availabilty = availabilty;
		Room_number = room_number;
		Capacity = capacity;
		this.College=c;
	}

	public	void	serialize()	throws	IOException	{

		ObjectOutputStream out	=	null;	
		try	{	
			out	=	new	ObjectOutputStream	(new FileOutputStream("./Room/"+Room_number+".txt"));	
			out.writeObject(this);	
		}	
		finally
		{	
			out.close();	
		}
	}
	public	static	Room deserialize(String u) throws	IOException,	ClassNotFoundException {ObjectInputStream	in	=	null;	
	try	{	
		String fo="Room/"+u;
		in	=		new	ObjectInputStream	(	new	FileInputStream(fo));	
		Room	s1	=	(Room)	in.readObject();	
		return s1;
	}	finally	{	
		in.close();	
	}	
	}

	public static Room getInstance(String substring, application.College college2) {
		// TODO Auto-generated method stub
		Room roo=null;
		int flag=0;
		for(Room r:college2.rooms)
		{
			if(r.Room_number.equals(substring)) {
				return r;			}
		}
		if(flag==0)
		{System.out.println("new obj created");
		roo=new Room(substring,college2);
		}


		return roo;
	}


}

