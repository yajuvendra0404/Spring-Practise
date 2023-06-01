package com.ktcart.webportal.controller;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user") // http://localhost:8080/users/
public class UserController {


	@GetMapping("/all")
	public String getAllUser() {
		return "get all user method called";
	}
	@GetMapping("/1")
	public String getUser() {
		return "get one user method called";
	}
	@PostMapping
	public String createUser() {
		return "post user method called";
	}
	@PutMapping
	public String updateUser() {
		return "update user method called";
	}
	@DeleteMapping
	public String deleteUser() {
		return "delete user method called";
	}
	
	/* Coaching API below
	 * details, 
	 * tips, 
	 * instruction  */ 
	
		
}
