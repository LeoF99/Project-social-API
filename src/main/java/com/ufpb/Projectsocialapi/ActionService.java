package com.ufpb.Projectsocialapi;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActionService {
	@Autowired
	private ActionRepository<Action, Long> ActionRepository;
	
	public Action newAction(String name, String description, String location) {
		Action a = new Action(name, description, location);
		ActionRepository.save(a);
		return a;
	}
	
	public Iterable<Action>getAllActions(){
		return ActionRepository.findAll();
	}
	
	public Optional<Action> getActionById(int id){
		return ActionRepository.findById(id);
	}
	
	public Action updateActionName(String name, int id) {
		Action a = ActionRepository.findById(id).get();
		if(a != null) {
			a.setName(name);
			ActionRepository.save(a);
			return a;
		}else {
			return null;
		}
	}
	
	public Action updateActionDescription(String desc, int id) {
		Action a = ActionRepository.findById(id).get();
		if(a != null) {
			a.setDescription(desc);
			ActionRepository.save(a);
			return a;
		}else {
			return null;
		}
	}
	
	public Action updateActionLocation(String location, int id) {
		Action a = ActionRepository.findById(id).get();
		if(a != null) {
			a.setLocation(location);
			ActionRepository.save(a);
			return a;
		}else {
			return null;
		}
	}
	
	public Action updateActionStatus(boolean status, int id) {
		Action a = ActionRepository.findById(id).get();
		if(a != null) {
			a.setStatus(status);
			ActionRepository.save(a);
			return a;
		}else {
			return null;
		}
	}
	
	public Action deleteAction(int id) {
		Action a = ActionRepository.findById(id).get();
		if(a != null) {
			ActionRepository.deleteById(id);
			return a;
		}else {
			return null;
		}
	}
}
