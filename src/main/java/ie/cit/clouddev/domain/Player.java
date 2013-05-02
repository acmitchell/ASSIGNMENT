package ie.cit.clouddev.domain;

import java.util.UUID;

@XMLRootElement(name="player")

public class Player {
	 String playerId;
	 String name;
	 Boolean fittoplay;
	 String dob;
	 
	public Boolean isfittoplay() {
		return fittoplay;
	}
	
    public void setFittoplay(boolean fittoplay) {
        this.fittoplay = fittoplay;
    }
	private String contactno;
	
	public Player() {
		setPlayerId(UUID.randomUUID().toString());
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getContactno() {
		return contactno;
	}
	public void setContactno(String contactno) {
		this.contactno = contactno ;
	}


	public String getPlayerId() {
		return playerId;
	}


	public void setPlayerId(String playerId) {
		this.playerId = playerId;
	}
	

}
