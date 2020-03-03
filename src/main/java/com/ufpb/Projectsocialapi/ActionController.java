package com.ufpb.Projectsocialapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ActionController {
	@Autowired
	private ActionService service;
	
	@RequestMapping(value = "/users/{uid}/actions", method = RequestMethod.POST)
	public ResponseEntity<Action> newAction(@RequestBody Action action, @PathVariable("uid")int uid){
		return new ResponseEntity<Action>(this.service.newAction(action.getName(), action.getDescription(), action.getlocation(), uid), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/actions", method = RequestMethod.GET)
	public ResponseEntity<Iterable<Action>> getAllActions(){
		return new ResponseEntity<Iterable<Action>>(this.service.getAllActions(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/users/{uid}/actions/{id}", method  = RequestMethod.GET)
	public ResponseEntity<Action> getActionById(@PathVariable("id")int id){
		Action a = this.service.getActionById(id).get();
		
		if (a != null) {
			return new ResponseEntity<Action>(a, HttpStatus.FOUND);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "/users/{uid}/actions/{id}/name", method = RequestMethod.PUT)
	public ResponseEntity<Action> updateActionName(@PathVariable("id")int id, @RequestBody String name){
		Action a = this.service.updateActionName(name, id);
		
		if(a != null) {
			return new ResponseEntity<Action>(a, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "/users/{uid}/actions/{id}/description", method = RequestMethod.PUT)
	public ResponseEntity<Action> updateActionDescription(@PathVariable("id")int id, @RequestBody String desc){
		Action a = this.service.updateActionDescription(desc, id);
		
		if(a != null) {
			return new ResponseEntity<Action>(a, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "/users/{uid}/actions/{id}/location", method = RequestMethod.PUT)
	public ResponseEntity<Action> updateActionLocation(@PathVariable("id")int id, @RequestBody String location){
		Action a = this.service.updateActionLocation(location, id);
		
		if(a != null) {
			return new ResponseEntity<Action>(a, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "/users/{uid}/actions/{id}/status", method = RequestMethod.PUT)
	public ResponseEntity<Action> updateActionStatus(@PathVariable("id")int id, @RequestBody boolean status){
		Action a = this.service.updateActionStatus(status, id);
		
		if(a != null) {
			return new ResponseEntity<Action>(a, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "/users/{uid}/actions/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Action> deleteAction(@PathVariable("id")int id){
		Action a = this.service.deleteAction(id);
		
		if(a != null) {
			return new ResponseEntity<Action>(a, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
