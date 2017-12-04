package ClubManagement;
public class Schedule {
	private double startHour;
	private double endHour;
	private String date;
	
	public Schedule() {
		startHour = 0;
		endHour = 0;
		date = "";
	}
	public double getStartHour() {
		return startHour;
	}
	public void setStartHour(double startHour) {
		this.startHour = startHour;
	}
	public double getEndHour() {
		return endHour;
	}
	public void setEndHour(double endHour) {
		this.endHour = endHour;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	public String getScheduleString() {
		String final_str = "";
		
		final_str = date + " " + Double.toString(startHour) + " - " + Double.toString(endHour);
		
		return final_str;
	}
}