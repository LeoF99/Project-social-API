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
}
