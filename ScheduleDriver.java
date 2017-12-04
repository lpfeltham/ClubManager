package ClubManagement;
 public class ScheduleDriver{
	 public static void main(String[] args) {
		 Schedule sch = new Schedule();
		 if(sch.getEndHour() != 0 | sch.getDate() != "" | sch.getStartHour() != 0) {
			 System.out.println("Error with Schedule constructor");
		 }
		 sch.setDate("11/14/2017");
		 if(sch.getDate() != "11/14/2017") {
			 System.out.println("Error with Schedule date"); 
		 }
		 sch.setEndHour(3);
		 if(sch.getEndHour() != 3) {
			 System.out.println("Error with Schedule endHour"); 
		 }
		 sch.setStartHour(2);
		 if(sch.getStartHour() != 2) {
			 System.out.println("Error with Schedule startHour"); 
		 }
	 }
 }