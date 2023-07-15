package com.Learn.eduTrack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Learn.eduTrack.service.StudentService;

@RestController
@RequestMapping("/student")
class StudentController {
	private StudentService studentService;
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public StudentController (
			StudentService studentService,
			JdbcTemplate jdbcTemplate
	) {
		this.studentService = studentService;
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@PostMapping("/show")
	public void student() {

		System.out.println("-- Student Acceessed --");
	}
	
	
}
