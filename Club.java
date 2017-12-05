package ClubManagement;

import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JButton;

public class Club {

	private String name;
	private double funds;
	private double dues;
	private String description;
	private ArrayList<User> members;
	private ArrayList<User> officers;
	private User president;
	private ArrayList<Event> events;
	private ArrayList<String> benefits;
	private JButton button;
	
	public Club() {
		name = "";
		funds = 0;
		dues = 0;
		description = "";
		members = new ArrayList<User>();
		officers = new ArrayList<User>();
		president = null;
		events = new ArrayList<Event>();
		benefits = new ArrayList<String>();
		button = new JButton();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
		this.button.setText(name);
	}
	public double getFunds() {
		return funds;
	}
	public void setFunds(double funds) {
		this.funds = funds;
	}
	public void addFunds(double funds) {
		this.funds += funds;
	}
	public void subtractFunds(double funds) {
		this.funds -= funds;
	}
	public double getDues() {
		return dues;
	}
	public void setDues(double dues) {
		this.dues = dues;
	}
	public JButton getButton() {
		return button;
	}
	public ArrayList<User> getMembers() { //cannot be tested yet
		return members;
	}
	public boolean removeMember(User member) { //cannot be tested yet
		for(int i = 0; i < members.size(); i++) {
				if(!member.getClub(name).getPosition().getName().equals("President")) {
					member.removeClub(name); //fix for Zahra, don't change
					if(members.get(i).getName().equals(member.getName())) {
						members.remove(i);
					}
					for(int j = 0; j < officers.size(); j++) {
						if (officers.get(i).getName() == member.getName()) {
							officers.remove(i);
						}
					return true;
				}
				return false;
			}
		}
		return false;
	}
	public User searchMember(String name) { //cannot be tested yet
		for(int i = 0; i < members.size(); i++) {
			if(members.get(i).getName().equals(name)) {
				return members.get(i); 
			}
		}
		return null;
	}
	public ArrayList<Event> getEvents() {
		return events;
	}
	public void addEvent(Event aEvent, String name, Schedule schedule, Place place, String dressCode, String description) {
		Integer flag = 0;
		Event event = new Event();
		event.setName(name);
		event.setSchedule(schedule);
		event.setDressCode(dressCode);
		event.setDescription(description);
		if(!event.ConflictingTimePlace(place)) {
			event.setPlace(place);
			flag = 1;
		}
		if(flag == 1) {
			events.add(event);
		}
	}
	
	public void addEvent(Event e1) {
		Event e2 = new Event();
		
		e2.setName(e1.getName());
		e2.setSchedule(e1.getSchedule());
		e2.setPlace(e1.getPlace());
		e2.setDressCode(e1.getDressCode());
		e2.setDescription(e1.getDescription());
		
		this.events.add(e2);
	}
	
	public boolean removeEvent(String name) {
		for(int i = 0; i < events.size(); i++) {
			if(events.get(i).getName().equals(name)) {
				events.remove(i);
				return true;
			}
		}
		return false;
	}
	public Event searchEvent(String name) {
		for(int i = 0; i < events.size(); i++) {
			if(events.get(i).getName().equals(name)) {
				return events.get(i);
			}
		}
		return null;
	}
	public ArrayList<String> getBenefits() {
		return benefits;
	}
	public void addBenefit(String benefit) {
		benefits.add(benefit);
	}
	public ArrayList<User> getOfficers() {
		return officers;
	}
	public void addOfficer(User user) {
		user.getClub(name).setPosition("Officer");
		officers.add(user);
	}
	public void removeOfficer(User user) {
		user.getClub(name).setPosition("Member");
		officers.remove(user);
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public User getPresident() {
		return president;
	}
	public void setPresident(User president) {	
			president.getClub(name).setPosition("President");
	}
	public void changePresident(User president) {
		this.president.getClub(name).setPosition("Member");
		this.president = president;
		president.getClub(name).setPosition("President");
	}
	public boolean checkUserConflict(User newUser) {
		if(members.contains(newUser)) {
			return true;
		}
		return false;
	}
	
	public void addUserToClub(User newUser) {
		if(!(checkUserConflict(newUser))) {
			this.members.add(newUser);
			newUser.updateUserPosition("Member", this);
		}
		else {
			System.out.println("already a member");
		}
	}
	public String printUsersScroller() {
		String final_str = "";
		final_str = final_str + "Members/n";
		
		for(int i = 0; i < members.size(); i++) {
			//if(members.get(i))
			final_str = final_str + members.get(i).getName() + "/n";
		}
		
		final_str = final_str + "/n/nOfficers/n";
		
		for(int i = 0; i < officers.size(); i++) {
			final_str = final_str + officers.get(i).getName() + "/n";
		}
		
		final_str = final_str + "/n/nPresident/n";
		
		final_str = final_str + president.getName();
		
		return final_str;
	}
	
}
