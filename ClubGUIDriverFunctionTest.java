package ClubManagement;

public class ClubGUIDriverFunctionTest {
	
	public static void main(String[] args) {
		Application app1 = new Application();
	
		User u1 = new User();
		u1.setName("Leah");
		u1.setUsername("lpfeltham");
		u1.setPassword("git");
		
		User u2 = new User();
		u2.setName("Kermit");
		u2.setUsername("The Frog");
		u2.setPassword("BitchPlease");
		
		app1.addUser(u1);
		app1.addUser(u2);
		
		if(app1.detectNewUserConflict("lpfeltham")) {
			System.out.println("Fuck yeah dude, that user already exists");
		}
		else {
			System.out.println("You suck at coding. that user should exist");
		}
		
		System.out.println(app1.printUsers());
		
		
	}
	
}
