package com.infotech.umc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.infotech.umc.entities.User;
import com.infotech.umc.services.UserService;

@Controller
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/list")
	public String displayUserList(Model model) {
		List<User> userList = userService.getUsers();
		model.addAttribute(userList);
		return "user-list";
	}
	
	@PostMapping("/add-user")
	public String registerUser(@ModelAttribute User user, RedirectAttributes redirectAttributes) {
		userService.addUser(user);
		return "redirect:/users/list";
	}
	
	@GetMapping("/edit-user-form/{id}")
	public String displayEditForm(@PathVariable("id")int userId, Model model) {
		User user = userService.getUser(userId);
		model.addAttribute(user);
		return "edit-form";
	}
	
	@GetMapping("/delete-user/{id}")
	public String deleteUser(@PathVariable("id")int userId, Model model) {
		userService.deleteUser(userId);
		model.addAttribute("message","User deleted successfully");
		return "redirect:/users/list";
	}
	
	
	@PostMapping("/edit-user")
	public String updateUser(@ModelAttribute User user, RedirectAttributes redirectAttributes) {
		User userToUpdate = userService.getUser(user.getUserId());
		userToUpdate.setName(user.getName());
		userToUpdate.setEmail(user.getEmail());
		userToUpdate.setPassword(user.getPassword());
		userService.addUser(userToUpdate);
		return "redirect:/users/list";
	}
}
