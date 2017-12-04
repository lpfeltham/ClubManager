package ClubManagement;

import java.util.ArrayList;

public class Application {

	public ArrayList<User> users;
	public ArrayList<Club> clubs;
	
	public Application() {
		users = new ArrayList<User>();
		clubs = new ArrayList<Club>();
	}
	
	public boolean detectNewUserConflict(String userName) {
		
		for(int i = 0; i < users.size(); i++) {
			if(users.get(i).getUsername().equals(userName)) {
				return true;
			}
		}
		return false;
	}
	public boolean detectConflict(User aUser) {
		if(users.contains(aUser)) {
			return true;
		}
		return false;
	}
	
	public void addClub(Club aClub) {
		this.clubs.add(aClub);
	}
	
	public ArrayList<Club> getClubs() {
		return clubs;
	}
	
	public void addUser(User aUser) {
		if(detectConflict(aUser) == false) {
			this.users.add(aUser);
		}
	}
	
	public ArrayList<User> getUsers() {
		return users;
	}
	
	public String printClubs() {
		String s1 = "";
		
		for(int i = 0; i < clubs.size(); i++) {
			s1 = s1 + clubs.get(i).getName() + "\n";
		}
		
		return s1;
	}
	
	public String printUsers() {
		String s1 = "";
		
		for(int i = 0; i < users.size(); i++) {
			s1 = s1 + users.get(i).getName() + "\n";
		}
		
		return s1;
	}
	
	public User checkPassword(String userName, String password) {
		
		for(int i = 0; i < users.size(); i++) {
			if(users.get(i).getUsername().equals(userName) && users.get(i).getPassword().equals(password)) {
				return users.get(i);
			}
		}
		
		return null;
	}
}