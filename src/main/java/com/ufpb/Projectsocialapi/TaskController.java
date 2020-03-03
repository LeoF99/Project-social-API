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
public class TaskController {
	@Autowired
	private TaskService service;
	
	@RequestMapping(value = "/users/{uid}/actions/{aid}/tasks", method = RequestMethod.POST)
	public ResponseEntity<Task> newTask(@RequestBody Task task, @PathVariable("aid")int actionId){
		return new ResponseEntity<Task>(this.service.newTask(task.getName(), task.getDescription(), actionId), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/users/{uid}/actions/{aid}/tasks", method = RequestMethod.GET)
	public ResponseEntity<Iterable<Task>> getAllTasks(){
		return new ResponseEntity<Iterable<Task>>(this.service.getAllTasks(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/users/{uid}/actions/{aid}/tasks/{tid}", method = RequestMethod.GET)
	public ResponseEntity<Task> getTaskById(@PathVariable("tid")int id){
		Task t = this.service.getTaskById(id).get();
		
		if (t != null) {
			return new ResponseEntity<Task>(t, HttpStatus.FOUND);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "/users/{uid}/actions/{aid}/tasks/{tid}/name", method = RequestMethod.PUT)
	public ResponseEntity<Task> updateTaskName(@PathVariable("tid")int id, @RequestBody String name){
		Task t = this.service.updateTaskName(name, id);
		
		if(t != null) {
			return new ResponseEntity<Task>(t, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "/users/{uid}/actions/{aid}/tasks/{tid}/description", method = RequestMethod.PUT)
	public ResponseEntity<Task> updateTaskDescription(@PathVariable("tid")int id, @RequestBody String desc){
		Task t = this.service.updateTaskDescription(desc, id);
		
		if(t != null) {
			return new ResponseEntity<Task>(t, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "/users/{uid}/actions/{aid}/tasks/{tid}/status", method = RequestMethod.PUT)
	public ResponseEntity<Task> updateTaskStatus(@PathVariable("tid")int id, @RequestBody boolean status){
		Task t = this.service.updateTaskStatus(status, id);
		
		if(t != null) {
			return new ResponseEntity<Task>(t, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "/users/{uid}/actions/{aid}/tasks/{tid}", method = RequestMethod.DELETE)
	public ResponseEntity<Task> deleteTask(@PathVariable("tid")int id){
		Task t = this.service.deleteTask(id);
		
		if(t != null) {
			return new ResponseEntity<Task>(t, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
