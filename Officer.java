package ClubManagement;

public class Officer extends Position {

	public Officer() {
		this.setName("Officer");
		this.addResponsibility("Running Meetings");
		this.addResponsibility("Collecting Dues");
		this.addResponsibility("Enforcing Safety Regulations");
		this.addResponsibility("Attending Events");
	}
	
	public void editEventSchedule(Event event, Schedule schedule) {
		event.setSchedule(schedule);
	}
	public void editEventName(Event event, String name) {
		event.setName(name);
	}
	public void editEventPlace(Event event, Place place) {
		event.setPlace(place);
	}
}

