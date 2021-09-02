package com.infotech.umc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/public")
public class PublicController {
	
	@GetMapping("/register")
	public String displayRegForm() {
		return "register-user";
	}
}
