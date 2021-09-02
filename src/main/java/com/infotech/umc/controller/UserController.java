package com.infotech.umc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
		redirectAttributes.addFlashAttribute("HELLO");
		return "redirect:/users/list";
	}
}
