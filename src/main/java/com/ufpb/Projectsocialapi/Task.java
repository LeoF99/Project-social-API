package com.ufpb.Projectsocialapi;


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
	private boolean status = true;
	
	public Task() {
		
	}
	
	public int getId() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public Task(String name, String description) {
		this.name = name;
		this.description = description;
	}

	public String getDescription() {
		return this.description;
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
