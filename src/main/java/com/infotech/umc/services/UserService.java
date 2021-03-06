package com.infotech.umc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infotech.umc.entities.User;
import com.infotech.umc.repos.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public User addUser(User user) {
		return userRepository.save(user);
	}
	
	public List<User> getUsers(){
		return (List<User>)userRepository.findAll();
	}
	
	public User getUser(int id) {
		return userRepository.findById(id).get();
	}
	
	public void deleteUser(int id) {
		userRepository.deleteById(id);
	}
	
	public User updateUser(User user) {
		User userToUpdate = getUser(user.getUserId());
		userToUpdate.setName(user.getName());
		userToUpdate.setEmail(user.getEmail());
		if(!user.getPassword().isEmpty()) {
			userToUpdate.setPassword(user.getPassword());
		}
		return addUser(userToUpdate);
	}
}
