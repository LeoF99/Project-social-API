package com.ufpb.Projectsocialapi;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
	private UserRepository<User, Long> userRepository;
	
	public User newUser(String name, String email, String username, String telefone) {
		User u = new User(name, email, username, telefone);
		userRepository.save(u);
		return u;
	}
	
	public Iterable<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	public Optional<User> getUserById(int id) {
		return userRepository.findById(id);
	}
	
	public User updateUserUsername(String username, int id) {
		User u = userRepository.findById(id).get();
		if(u != null) {
			u.setUsername(username);
			userRepository.save(u);
			return u;
		}else {
			return null;
		}
	}
	
	public User updateUserPhoneNumber(String phone, int id) {
		User u = userRepository.findById(id).get();
		if(u != null) {
			u.setPhoneNumber(phone);
			userRepository.save(u);
			return u;
		}else {
			return null;
		}
	}
	
	public User updateUserEmail(String email, int id) {
		User u = userRepository.findById(id).get();
		if(u != null) {
			u.setEmail(email);
			userRepository.save(u);
			return u;
		}else {
			return null;
		}
	}
	
	public User deleteUser(int id) {
		User u = userRepository.findById(id).get();
		if(u != null) {
			userRepository.deleteById(id);
			return u;
		}else {
			return null;
		}
	}
}
