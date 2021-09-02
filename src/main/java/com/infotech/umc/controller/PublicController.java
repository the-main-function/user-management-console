package com.infotech.umc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.infotech.umc.entities.User;

@Controller
@RequestMapping("/public")
public class PublicController {
	
	@GetMapping("/register")
	public String displayRegForm(Model model) {
		model.addAttribute("user", new User());
		return "register-user";
	}
	
	@GetMapping("/login")
	public String displayLoginForm() {
		return "login";
	}
}
