package com.infotech.umc.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.infotech.umc.entities.User;

@Controller
@RequestMapping("/public")
public class PublicController {
	
	
	@GetMapping("/register")
	public String displayRegForm(Model model, Principal principal) {
		if(!(principal == null)) {
			return "redirect:/users/list";
		}
		model.addAttribute("user", new User());
		return "register-user";
	}
	
	@GetMapping("/login")
	public String displayLoginForm(Principal principal) {
		if(!(principal == null)) {
			return "redirect:/users/list";
		}
		return "login";
	}
}
