package ClubManagement;

import java.util.ArrayList;


public class EventDriver {

	public static void main(String[] args) {

	//*****************  Initialize  Event  *****************//
		
		Event e1 = new Event();
		Event e2 = new Event();
	
	//*****************  Initialize  Clubs and Users  *****************//
		
		Club c1 = new Club();
		Club c2 = new Club();
		
		User u1 = new User();
		User u2 = new User();
		User u3 = new User();
		User u4 = new User();
		User u5 = new User();
		
		c1.setName("Baja Racing");
		c2.setName("IEEE");
		
		u1.setName("Laura");
		u2.setName("Leah");
		u3.setName("Zahra");
		u4.setName("Kyle");
		u5.setName("Adrien");
		
		e1.setName("My Birthday");
		e1.setDressCode("Casual");
		e1.addMember(u1);
		e1.addMember(u2);
		e1.addMember(u3);
		e1.addOfficer(u5);
		//e1.setClub(c2);
		
		Schedule s1 = new Schedule();
		s1.setDate("December 1");
		s1.setStartHour(100);
		s1.setEndHour(200);
		
		e1.setSchedule(s1);
		
		System.out.println("Event Name: " + e1.getName());
		//System.out.println("Event's Club Name: " + e1.getClub().getName());
		
		System.out.println("Event Dress Code: " + e1.getDressCode());
		System.out.println("Event Members attending: ");
		
		for(int i = 0; i < e1.getMembers().size(); i++) {
			System.out.println(e1.getMembers().get(i).getName());
		}
		
		System.out.println("Event Officer attending: ");
		for(int i = 0; i < e1.getOfficers().size(); i++) {
			System.out.println(e1.getOfficers().get(i).getName());
		}
		
		System.out.println("Event Schedule (times to be translated) " + e1.getSchedule().getDate());
		
		
		
		
		
	   
	}
	
}