package ClubManagement;

import java.util.ArrayList;


public class ApplicationDriver {

	public static void main(String[] args) {

	//*****************  Initialize  Application  *****************//
		
		Application app1 = new Application();
	
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
		
		app1.addClub(c1);
		app1.addClub(c2);
		
		app1.addUser(u1);
		app1.addUser(u2);
		app1.addUser(u3);
		app1.addUser(u4);
		app1.addUser(u5);
		
		System.out.println(app1.printClubs());
		System.out.println(app1.printUsers());
	   
	}
	
}