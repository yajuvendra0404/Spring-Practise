package com.Learn.eduTrack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Learn.eduTrack.model.ResponseMessage;
import com.Learn.eduTrack.model.TeacherModel;
import com.Learn.eduTrack.service.TeacherService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
	
	private TeacherService teacherService;
	private ResponseMessage responseMessage;
	
	@Autowired
	public TeacherController (
			TeacherService teacherService,
			ResponseMessage responseMessage
	) {
		this.teacherService = teacherService;
		this.responseMessage =  responseMessage;
	}
	
	@PostMapping("/add")
	public ResponseMessage addTeacher(@RequestBody TeacherModel teacherModel, HttpSession httpSession) {
		if(teacherModel.getAddress() == null) {
			
			this.responseMessage.setMessage("Please enter address");
			this.responseMessage.setStatus(400);
			this.responseMessage.setError(true);
			
		}
		if(teacherModel.getEmail() == null) {
			
			this.responseMessage.setMessage("Please enter email");
			this.responseMessage.setStatus(400);
			this.responseMessage.setError(true);
			
		}
		if(teacherModel.getDepartment() == null) {
			
			this.responseMessage.setMessage("Please enter department");
			this.responseMessage.setStatus(400);
			this.responseMessage.setError(true);
			
		}
		if(teacherModel.getName() == null) {
			
			this.responseMessage.setMessage("Please enter name");
			this.responseMessage.setStatus(400);
			this.responseMessage.setError(true);
			
		}
		if(teacherModel.getPhone() == null) {
			
			this.responseMessage.setMessage("Please enter phone number");
			this.responseMessage.setStatus(400);
			this.responseMessage.setError(true);
			
		}

//		if( httpSession.getAttribute("sessionToken") == null) {
//			this.responseMessage.setMessage("Please login as HR Manager");
//			this.responseMessage.setStatus(400);
//			this.responseMessage.setError(true);
//
//		}
		
		if( this.teacherService.addTeacher(teacherModel) == 0) {
			this.responseMessage.setMessage("error occured while inserting data");
			this.responseMessage.setStatus(400);
			this.responseMessage.setError(true);
		} else {
			this.responseMessage.setMessage("data inserted Successfully");
			this.responseMessage.setStatus(200);
			this.responseMessage.setError(false);
		}
		
		return this.responseMessage;
	}

	@GetMapping("/test")
	public String testApi() {
		return "good one";
	}
	
	
}
