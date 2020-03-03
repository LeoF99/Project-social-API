package com.ufpb.Projectsocialapi;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String senha;
	private String name;
	private String email;
	private String username;
	private String phoneNumber;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Action> actions;
	
	public List<Task> getActiveTasks() {
		return activeTasks;
	}

	public void setActiveTasks(List<Task> activeTasks) {
		this.activeTasks = activeTasks;
	}

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "join_action",
			joinColumns = @JoinColumn(name = "action_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"))
	private List<Action> activeActions;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "join_task",
			joinColumns = @JoinColumn(name = "task_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"))
	private List<Task> activeTasks;
	
	public List<Action> getActiveActions() {
		return activeActions;
	}

	public void setActiveActions(List<Action> activeActions) {
		this.activeActions = activeActions;
	}

	public User() {
		
	}
	
	public User(String name, String email, String username, String phoneNumber) {
		this.name = name;
		this.email = email;
		this.username = username;
		this.phoneNumber = phoneNumber;
	}

	public int getId() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public String getPhoneNumber() {
		return this.phoneNumber;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}
