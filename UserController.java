package com.komal.coupon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.komal.coupon.model.User;
import com.komal.coupon.repository.UserRepository;
import com.komal.coupon.security.SecurityService;

@Controller
public class UserController {

	@Autowired
	public SecurityService securityService;
	
	@Autowired
	public UserRepository repo;
	
	@Autowired
	public PasswordEncoder encoder;
	
	@GetMapping("/")
	public String showLoginPage() {
		return "login";
	}
	
	@PostMapping("/login")
	public String login(String email,String password) {
		boolean loginResponse=securityService.login(email, password);
		System.out.println("loginResponse is: "+loginResponse);
		if(loginResponse)
			return "index";
		return "login";
	}
	
	@GetMapping("/showReg")
	public String showRegisterationPage() {
		return "registerUser";
	}
	
	@PostMapping("/registerUser")
	public String register(User user) {
		user.setPassword(encoder.encode(user.getPassword()));
		repo.save(user);
		return "login";
	}
}
