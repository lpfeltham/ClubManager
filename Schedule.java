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
}