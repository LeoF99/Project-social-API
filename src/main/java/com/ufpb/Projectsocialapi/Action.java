package com.ufpb.Projectsocialapi;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Action {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	private String description;
	private String location;
	private boolean status = true;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	@OneToMany(mappedBy = "action", cascade = CascadeType.ALL)
	private List<Task> tasks;
	
	public List<User> getActiveUsers() {
		return activeUsers;
	}

	public void setActiveUsers(List<User> activeUsers) {
		this.activeUsers = activeUsers;
	}

	@ManyToMany
	private List<User> activeUsers;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

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
