package ClubManagement;

import java.io.Serializable;
import java.util.ArrayList;

public class Position implements Serializable{
	
	// class variables
	private ArrayList<String> responsibility;
	protected String name;
	
	
	// constructor
	public Position() {
		//responsibilities = new ArrayList<String>();
		responsibility = new ArrayList<String>();
		addResponsibility("Paying Dues");
		setName(new String());
	}
	
	// getters and setters

	public void addResponsibility(String aResponse) {
		responsibility.add(aResponse);
		
	}
	public ArrayList<String> getResponsibilities() {
		return responsibility;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
