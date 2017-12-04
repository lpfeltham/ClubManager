package ClubManagement;

public class TestDriverClub{
	public static void main(String[] args) {
		Club club = new Club();
		if(club.getName() != "" | club.getDues() != 0 | club.getFunds() != 0 | club.getDescription() != "") {
			System.out.println("Error with Club constructor");
		}
		club.setName("Baja");
		if(club.getName() != "Baja") {
			System.out.println("Error with Club name getter/setter");
		}
		club.setFunds(10);
		club.addFunds(5);
		club.subtractFunds(2);
		if(club.getFunds()!= 13) {
			System.out.println("Error with Club funds");
		}
		club.setDues(25);
		if(club.getDues()!=25) {
			System.out.println("Error with Club dues");
		}
		club.setDescription("Racing Team");
		if(club.getDescription()!= "Racing Team") {
			System.out.println("Error with Club description");
		}
		Event event = new Event();
		event.setName("Competition");
		//club.addEvent(event);
		if(club.getEvents().get(0).getName() != event.getName()) {
			System.out.println("Error with Club Event");
		}
		club.addBenefit("Friends");
		if(club.getBenefits().get(0) == "Friends") {
			System.out.println("Error with Club Benefits");
		}
	}
}