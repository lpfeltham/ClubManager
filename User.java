package ClubManagement;

import java.util.ArrayList;

public class User {
	private String name;
	private String username;
	private String password;
	private int year;
	private ArrayList<Management> management;
	private ArrayList<Schedule> schedule;
	
	public User(){
		name = "";
		username = "";
		password = "";
		year = 0;
		management = new ArrayList<Management>();
		schedule = new ArrayList<Schedule>();
	}
	public String getName (){
		return name;
	}
	public void setName(String aName) {
		this.name= aName;
	}
	public String getUsername (){
		return username;
	}
	public void setUsername(String aUsername) {
		this.username = aUsername;
	}
	public String getPassword (){
		return password;
	}
	public void setPassword (String aPassword) {
		this.password = aPassword;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int aYear) {
		this.year = aYear;
	}
	public ArrayList<Management> getManagement(){
		return management;
	}
	public ArrayList<Schedule> getSchedule() {
		return this.schedule;
	}
	// returns true if there is a conflict
	public boolean detectConflict(Schedule aSchedule) {
		for(int i = 0; i < schedule.size(); i++) {
			if(aSchedule.getStartHour() >= schedule.get(i).getStartHour() && aSchedule.getStartHour() <= schedule.get(i).getEndHour()) {
				return true;
			}
				
			if(aSchedule.getEndHour() >= schedule.get(i).getStartHour() && aSchedule.getEndHour() <= schedule.get(i).getEndHour()) {
				return true;
			}
		}
		return false;
	}
	public Management getClub(String name){
		for(int i = 0; i < management.size(); i++) {
			if(management.get(i).getClub().getName().equals(name)) {
				return management.get(i);
			}
		}
		return null;
	}
	public boolean checkConflict(Club aClub) { //checking if the club exists
		//one person can only hold one position
		for(int i = 0; i< management.size();i++) {
			if(management.get(i).getClub() == aClub) {
				return true;
			}
		}		
		return false; // there isnt any conflict
	}
	public void addClub(Club aClub) { //the user enters in 
		//the club and position
		if(checkConflict(aClub) == false){
			Management man = new Management();
			man.setClub(aClub);
			man.setPosition("Member");
			aClub.addUserToClub(this);
			this.management.add(man);
		}
		else {
			System.out.println("There was a conflict adding the club");
		}
	}

	public void removeClub(String name) { 

		for(int i =0; i< management.size(); i++) {
			if(management.get(i).getClub().getName().equals(name)) {
				management.get(i).getClub().removeMember(this);

				
			}
		}
		
	}
	public void signUpForEvent(Event event) { //FIXME does check conflict need to be called here? are we checking for scheduling conflicts for users? can we not?
		if(!(detectConflict(event.getSchedule()))) {
			this.schedule.add(event.getSchedule());
			event.addMember(this);
		}
		else {
			System.out.println("Stop trying to schedule your events at the same time!");
		}
	}
	
	public String findPosition(Club aClub) {
		String finalStr = "";
		
		for(int i = 0; i < management.size(); i++) {
			if(aClub.getName().equals(management.get(i).getClub().getName())) {
				finalStr = management.get(i).getPosition().getName();
			}
		}
		
		return finalStr;
	}
	
	public Position findMember(Club aClub) {
		Position p1 = new Position();
		for(int i = 0; i < management.size(); i++) {
			if(aClub == management.get(i).getClub()) {
				p1 =  management.get(i).getPosition();
			}
		}
		return p1;
	}

	
}	
