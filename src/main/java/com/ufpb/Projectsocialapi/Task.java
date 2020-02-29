package com.ufpb.Projectsocialapi;


import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Task {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	private String description;
	private ArrayList<User> participants = new ArrayList<User>();
	private boolean status;
	
	public Task() {
		
	}
	
	public int getId() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public Task(String name, String description, ArrayList<User> participants, boolean status) {
		this.name = name;
		this.description = description;
		this.participants = participants;
		this.status = status;
	}

	public String getDescription() {
		return this.description;
	}
	
	public ArrayList<User> getParticipants(){
		return this.participants;
	}
	
	public boolean getStatus() {
		return this.status;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setStatus(boolean status) {
		this.status = status;
	}
}
