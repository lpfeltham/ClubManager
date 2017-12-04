package ClubManagement;

public class userDriver {
	
	public static void main(String[] args) {

		//*****************  Initialize  User  *****************//
			
			User u1 = new User();
			User u2 = new User();
			
			Club c1 = new Club();
			Position p1 =  new Position();
		
		//*****************  Initializing Users  *****************//
			c1.setName("Baja Racing");
			
			
			u1.setName("Karen");
			u1.setUsername("myUser");
			u1.setPassword("myPass123");
			u1.setYear(1);
			//cant test the adding club because I need management class
			
	
			u2.setName("Mia");
			u2.setUsername("myUserMia");
			u2.setPassword("Mia1234");
			u2.setYear(2);
			
			
		
		   
		}
}
