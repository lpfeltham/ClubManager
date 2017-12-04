package ClubManagement;

import java.io.Serializable;
import java.util.ArrayList;

public class Basic extends Club {
	private String departement;

	public Basic() {
		departement = "";
	}
	public String getDepartement() {
		return departement;
	}

	public void setDepartement(String departement) {
		this.departement = departement;
	}

}