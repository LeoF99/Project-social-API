package com.ufpb.Projectsocialapi;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Action {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	private String description;
	private String location;
	private boolean status = true;
	
	public Action() {
		
	}
	
	public Action(String name, String description, String location) {
		this.name = name;
		this.description = description;
		this.location = location;
	}

	public int getId() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public String getlocation() {
		return this.location;
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
	
	public void setLocation(String location) {
		this.location = location;
	}
	
	public void setStatus(boolean status) {
		this.status = status;
	}
}
