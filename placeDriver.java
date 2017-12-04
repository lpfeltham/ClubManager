package ClubManagement;

public class placeDriver {
	public static void main(String[] args) {

		//*****************  Initialize  User  *****************//
			
			Place pa1 = new Place();
			Place pa2 = new Place();
			
			Schedule s1 = new Schedule();
			Schedule s2 = new Schedule();
			Schedule s3 = new Schedule();
			
		
		//*****************  Initializing Users  *****************//
			String a1 = "2345 E Roady rd";
			String a2 = "1245 W Highland rd";
			
			pa1.setAddress(a1);
			pa2.setAddress(a2);
			
			s1.setDate("11/14/2017");
			s1.setStartHour(10.30);
			s1.setEndHour(11.30);
			
			pa1.addSchedule(s1);
			
			s2.setDate("11/15/2017");
			s2.setStartHour(11.30);
			s2.setEndHour(12.30);
			
			pa2.addSchedule(s2);
			
			
			s3.setDate("11/16/2017");
			s3.setStartHour(12.30);
			s3.setEndHour(1.30);
			
			pa2.addSchedule(s3);
			
			pa2.cancelSchedule(s3);
			
			
		}
}
