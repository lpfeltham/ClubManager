package ClubManagement;



public class ClubGUIDriver {
	
	public static void main(String[] args) {
		// create the new application with list of users and clubs
		Application app1 = new Application();
		
		Club c1 = new Club();
		Club c2 = new Club();
		Club c3 = new Club();
		Club c4 = new Club();
		Club c5 = new Club();
		
		c1.setName("IEEE");
		c1.setDues(15.00);
		c1.setDescription("A romp and a riot");
		c1.setFunds(0.00);
		//c1.setPresident(null);
		
		c2.setName("Baja");
		c2.setDues(13.00);
		c2.setDescription("a club that is dangerous for cars but fun for people");
		c2.setFunds(0.00);
		//c2.setPresident(null);
		
		c3.setName("UA Autonomous");
		c3.setDues(10.00);
		c3.setDescription("We fly stuff sometimes");
		c3.setFunds(0.00);
		//c3.setPresident(null);
		
		c4.setName("Hacks");
		c4.setDues(11.00);
		c4.setDescription("servers");
		c4.setFunds(0.00);
		//c4.setPresident(null);
		
		c5.setName("Booty Call Club");
		c5.setDues(18.00);
		c5.setDescription("We booty call");
		c5.setFunds(0.00);
		//c5.setPresident(null);
		
		app1.addClub(c1);
		app1.addClub(c2);
		app1.addClub(c3);
		app1.addClub(c4);
		app1.addClub(c5);
		
		User u1 = new User();
		User u2 = new User();
		User u3 = new User();
		
		u1.setName("Leah");
		u1.setUsername("lpfeltham");
		u1.setPassword("git");
		
		u2.setName("Zahra");
		u2.setUsername("Zahra");
		u2.setPassword("git");
		
		u3.setName("Laura");
		u3.setUsername("Laura");
		u3.setPassword("git");
		
		u1.addClub(c1);
		u1.addClub(c3);
		
		u2.addClub(c1);
		u3.addClub(c1);
		
		c1.addOfficer(u2);
		
		c1.setPresident(u1);
		
		u3.addClub(c1);
		
		Place p1 = new Place();
		p1.setAddress("ECE Room 105");
		
		Place p2 = new Place();
		p2.setAddress("ECE Room 555");
		
		
		Schedule s1 = new Schedule();
		s1.setDate("August 30");
		s1.setStartHour(9.00);
		s1.setEndHour(10.00);
		
		Schedule s2 = new Schedule();
		s2.setDate("November 30");
		s2.setStartHour(9.00);
		s2.setEndHour(10.00);
		
		//p1.addSchedule(s1);
		
		Event e1 = new Event();
		e1.setName("Officer Meeting");
		e1.setDressCode("Casual");
		e1.setSchedule(s1);
		e1.setPlace(p1);
		
		
		Event e2 = new Event();
		e2.setName("Big Club Meeting");
		e2.setDressCode("Casual");
		e2.setSchedule(s2);
		e2.setPlace(p2);
		
		
		//p1.addSchedule(s1);
		System.out.println(p1.getSchedule().get(0).getDate());
		
		c1.addEvent(e1);
		c1.addEvent(e2);
		
		app1.addPlace(p1);
		app1.addPlace(p2);
		
		app1.addUser(u1);
		app1.addUser(u2);
		app1.addUser(u3);
		
		// build the GUI
		ClubGUI newGUI = new ClubGUI("ClubGUI", app1);	
	}
}
