package ClubManagement;

import java.util.ArrayList;

public class Event {
	
	private String name;
	private Schedule schedule;
	private Place place;
	private String dressCode;
	private ArrayList<User> MemberAttendees;
	private ArrayList<User> OfficerAttendees; 
	private String description;
	
	public Event() {
		name = new String();
		schedule = new Schedule();
		place = new Place();
		dressCode = new String();
		MemberAttendees = new ArrayList<User>();
		OfficerAttendees = new ArrayList<User>();
		description = new String();
		
	}
	
	public void setName(String aName) {
		name = aName;
	}
	
	public String getName() {
		return name;
	}
	
	public void setDressCode(String aCode) {
		dressCode = aCode;
	}
	
	public String getDressCode() {
		return dressCode;
	}
	
	public void setSchedule(Schedule aSchedule) {
		schedule = aSchedule;
	}
	
	public Schedule getSchedule() {
		return schedule;
	}
	
	public void addMember(User aMember) {
		this.MemberAttendees.add(aMember);
	}
	
	public ArrayList<User> getMembers() {
		return MemberAttendees;
	}
	
	public void addOfficer(User aOfficer) {
		this.OfficerAttendees.add(aOfficer);
	}
	
	public ArrayList<User> getOfficers() {
		return OfficerAttendees;
	}
	
	public boolean ConflictingTimePlace(Place place) {
		return place.detectScheduleConflict(schedule);
	}

	public Place getPlace() {
		return place;
	}

	public void setPlace(Place place) {
		this.place = place;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
