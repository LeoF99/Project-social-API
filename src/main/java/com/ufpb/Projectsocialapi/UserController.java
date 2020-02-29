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
@RequestMapping(path="/users")
public class UserController {
	@Autowired
	private UserService service;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<User> newUser(@RequestBody User user){
		return new ResponseEntity<User>(this.service.newUser(user.getName(), user.getEmail(), user.getUsername(), user.getPhoneNumber()), HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Iterable<User>> getAllUsers(){
		return new ResponseEntity<Iterable<User>>(this.service.getAllUsers(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<User> getUserById(@PathVariable("id")int id){
		User u = this.service.getUserById(id).get();
		
		if(u != null) {
			return new ResponseEntity<User>(u, HttpStatus.FOUND);
		}else{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "/username/{id}", method = RequestMethod.PUT)
	public ResponseEntity<User> updateUserUsername(@PathVariable("id")int id, @RequestBody String username){
		User u = this.service.updateUserUsername(username, id);
		
		if(u != null) {
			return new ResponseEntity<User>(u, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "/phone/{id}", method = RequestMethod.PUT)
	public ResponseEntity<User> updateUserPhoneNumber(@PathVariable("id")int id, @RequestBody String phone){
		User u = this.service.updateUserPhoneNumber(phone, id);
		
		if(u != null) {
			return new ResponseEntity<User>(u, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "/email/{id}", method = RequestMethod.PUT)
	public ResponseEntity<User> updateUserEmail(@PathVariable("id")int id, @RequestBody String email){
		User u = this.service.updateUserEmail(email, id);
		
		if(u != null) {
			return new ResponseEntity<User>(u, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<User> deleteUser(@PathVariable("id")int id){
		User u = this.service.deleteUser(id);
		
		if(u != null) {
			return new ResponseEntity<User>(u, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}