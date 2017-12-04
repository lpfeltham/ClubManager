package ClubManagement;
public class Fraternity extends Club {
	private String building;
	private String motto;
	private String organization;
	
	public Fraternity() {
		building = new String();
		motto = new String();
		organization = new String();
	}
	public String getBuilding() {
		return building;
	}

	public void setBuilding(String building) {
		this.building = building;
	}

	public String getMotto() {
		return motto;
	}

	public void setMotto(String motto) {
		this.motto = motto;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}
}