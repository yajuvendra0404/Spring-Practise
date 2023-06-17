package com.learn.RESTApi.RestControllers;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.RESTApi.Models.Student;
import com.learn.RESTApi.Services.StudentService;

@RestController
@RequestMapping("/student")
public class StudentRest {
	
	private StudentService studentService;
	
	@Autowired
	public StudentRest ( 
			@Qualifier("StudentService") StudentService studentService
	) {
		this.studentService = studentService;
	}
	
	/* Rest API to fetch all students */
	@GetMapping("/")
	public List<Student> getAllStudent() {
		return this.studentService.getAllStudent();
	}
	
	/*Rest API to fetch one students by Id of that student*/
	@GetMapping("/{id}")
	public List<Student> getStudentById (@PathVariable int id) {
		return this.studentService.getStudentByID(id);
	}
	
	/*RESt API for adding new Student to the database*/
	@PostMapping("/{email}/{firstName}/{lastName}/{marks}")
	public void addStudent(@PathVariable String email , @PathVariable String firstName , @PathVariable String lastName, @PathVariable int marks ) {
		this.studentService.addStudent(email, firstName, lastName, marks);
	}	
	
}
