package ie.cit.clouddev.domain;

import java.util.UUID;

@XMLRootElement(name="player")

public class Player {
	 String playerId;
	 String name;
	 boolean fittoplay;
	 String manager;
	 String dob;
	 String contactno;
		
	public Player() {
			setPlayerId(UUID.randomUUID().toString());
	}
	public boolean isfittoplay() {
		return fittoplay;
	}
	
    public void setFittoplay(boolean fittoplay) {
        this.fittoplay = fittoplay;
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
	
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
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
