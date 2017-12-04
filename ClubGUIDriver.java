package ClubManagement;



public class ClubGUIDriver {
	
	public static void main(String[] args) {
		// create the new application with list of users and clubs
		Application app1 = new Application();
		
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
		
		app1.addUser(u1);
		app1.addUser(u2);
		app1.addUser(u3);
		
		Club c1 = new Club();
		Club c2 = new Club();
		Club c3 = new Club();
		
		c1.setName("IEEE");
		c1.setDues(15.00);
		c1.setDescription("A romp and a riot");
		c1.setFunds(0.00);
		u1.addClub(c1);
		c1.setPresident(u1);
		
		c2.setName("Baja");
		c2.setDues(13.00);
		c2.setDescription("a club that is dangerous for people but fun for cars");
		c2.setFunds(0.00);
		u2.addClub(c2);
		c2.setPresident(u2);
		
		c3.setName("UA Autonomous");
		c3.setDues(10.00);
		c3.setDescription("We fly stuff sometimes");
		c3.setFunds(0.00);
		u3.addClub(c3);
		c3.setPresident(u3);
		
		app1.addClub(c1);
		app1.addClub(c2);
		app1.addClub(c3);
		
		// build the GUI
		ClubGUI newGUI = new ClubGUI("ClubGUI", app1);	
	}
}
