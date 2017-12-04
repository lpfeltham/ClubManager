package ClubManagement;

import java.util.ArrayList;

public class Place {
	private String address;
	private ArrayList<Schedule> schedule;
	
	public Place() {
		address = "";
		schedule = new ArrayList<Schedule>();
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public ArrayList<Schedule> getSchedule() {
		return schedule;
	}
	// returns true if there is a conflict
	public boolean detectScheduleConflict(Schedule aSchedule) {
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
	public void addSchedule(Schedule aSchedule) {
		if(detectScheduleConflict(aSchedule)  == false) {
			this.schedule.add(aSchedule);
		}
	}
	
	public void cancelSchedule(Schedule aSchedule) {
		if(schedule.contains(aSchedule)) {
			schedule.remove(aSchedule);
		}
	}
	
	
	
}
