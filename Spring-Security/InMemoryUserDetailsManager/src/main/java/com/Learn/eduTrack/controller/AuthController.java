package com.Learn.eduTrack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Learn.eduTrack.model.AuthModel;
import com.Learn.eduTrack.model.HRManagerModel;
import com.Learn.eduTrack.model.StudentModel;
import com.Learn.eduTrack.model.TeacherModel;
import com.Learn.eduTrack.service.AuthService;


import jakarta.servlet.http.HttpSession;


@RestController
@RequestMapping("/auth")
public class AuthController {

	private AuthService authService;
	
	@Autowired
	public AuthController(
			AuthService authService
	) {
		this.authService = authService;
	}
	
	/* Student login and logout API*/
	@PostMapping("/std/login")
	public StudentModel studentAuth(@RequestBody AuthModel authModel, HttpSession httpSession) {
		this.authService.isStudentAuthorized(authModel);
		return null;
	}
	
	@PostMapping("/std/logout")
	public StudentModel studentLogout(HttpSession httpSession) {
		return null;
	}

	
	/* Teacher login and logout API*/
	@PostMapping("/tch/login")
	public String TeacherAuth(@RequestBody AuthModel authModel, HttpSession httpSession) {
		this.authService.isTeacherAuthorized(authModel);
		if ( this.authService.isTeacherAuthorized(authModel) ) {
			httpSession.setAttribute("sessionToken", authModel.getEmail());
			return "Login Success";
		} else {
			httpSession.setAttribute("sessionToken", null);
			return "Login Unsuccessful";
		}
	}
	
	@PostMapping("/tch/logout")
	public String TeacherLogout( HttpSession httpSession) {
		if ( httpSession.getAttribute("sessionToken") != null) httpSession.invalidate();
		return "Logout Success";
	}
	
	
	/* HR Manager login and logout API*/
	@PostMapping("/hr/login")
	public String hrManagerAuth(@RequestBody AuthModel authModel, HttpSession httpSession) {
		
		if ( this.authService.isHrManagerAuthorized(authModel) ) {
			httpSession.setAttribute("sessionToken", authModel.getEmail());
			return "Login Success";
		} else {
			httpSession.setAttribute("sessionToken", null);
			return "Login Unsuccessful";
		}
		
	}
	
	@PostMapping("/hr/logout")
	public String hrManagerAuth(HttpSession httpSession) {
		if ( httpSession.getAttribute("sessionToken") != null) httpSession.invalidate();
		return "Logout Success";
	}
		
	@PostMapping("/hr/check")
	public String checking(HttpSession httpSession) {
		System.out.println("--- session --- "+ httpSession.getAttribute("sessionToken"));
		return "Logout Success";
	}
		
	
	
}
