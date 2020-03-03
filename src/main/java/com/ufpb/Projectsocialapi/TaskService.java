package com.ufpb.Projectsocialapi;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
	@Autowired
	private TaskRepository<Task, Long> taskRepository;
	@Autowired
	private ActionRepository<Action, Long> actionRepository;
	
	public Task newTask(String name, String desc, int actionId) {
		Action a = actionRepository.findById(actionId).get();
		Task t = new Task(name, desc);
		t.setAction(a);
		taskRepository.save(t);
		return t;
	}
	
	public Iterable<Task> getAllTasks(){
		return taskRepository.findAll();
	}
	
	public Optional<Task> getTaskById(int id){
		return taskRepository.findById(id);
	}
	
	public Task updateTaskName(String name, int id) {
		Task t = taskRepository.findById(id).get();
		if(t != null) {
			t.setName(name);
			taskRepository.save(t);
			return t;
		}else {
			return t;
		}
	}
	
	public Task updateTaskDescription(String desc, int id) {
		Task t = taskRepository.findById(id).get();
		if(t != null) {
			t.setDescription(desc);
			taskRepository.save(t);
			return t;
		}else {
			return t;
		}
	}
	
	public Task updateTaskStatus(boolean status, int id) {
		Task t = taskRepository.findById(id).get();
		if(t != null) {
			t.setStatus(status);
			taskRepository.save(t);
			return t;
		}else {
			return t;
		}
	}
	
	public Task deleteTask(int id) {
		Task t = taskRepository.findById(id).get();
		if(t != null) {
			taskRepository.deleteById(id);
			return t;
		}else {
			return null;
		}
	}
}
