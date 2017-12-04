package ClubManagement;

import java.io.Serializable;

public class Management implements Serializable{
	private Club club;
	private Position position;
	
	public Management() {
		club = new Club();
		position = new Position();
	}
	
	public void setClub(Club aClub) {
		this.club = aClub;
		//aClub.addUserToClub(this);
	}
	
	public Club getClub() {
		return this.club;
	}
	
	public void setPosition(String pos) {
		switch(pos) {
		case "Member":
			position = new Member();
			break;
		case "Officer":
			position = new Officer();
			break;
		case "President":
			position = new President();
			break;
		}
	}
	
	public Position getPosition() {
		return this.position;
	}
}
