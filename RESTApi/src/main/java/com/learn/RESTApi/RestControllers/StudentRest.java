package com.learn.RESTApi.RestControllers;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.RESTApi.Models.ExceptionResponse;
import com.learn.RESTApi.Models.Student;
import com.learn.RESTApi.Models.Teacher;
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
	@GetMapping("")
	public List<Student> getAllStudent() {
		return this.studentService.getAllStudent();
	}
	
	/*Rest API to fetch one students by Id of that student*/
	@GetMapping("/{id}")
	public Student getStudentById (@PathVariable int id)  {
		return this.studentService.getStudentByID(id);
	}
	
	/*RESt API for adding new Student to the database*/
	@GetMapping("/{email}/{firstName}/{lastName}/{marks}")
	public void addStudent(@PathVariable String email , @PathVariable String firstName , @PathVariable String lastName, @PathVariable int marks ) {
		this.studentService.addStudent(email, firstName, lastName, marks);
	}	
	
	/*this method use JSON received from the client to insert the data into Teacher Table*/
	@PostMapping("/insert") 
	public void addTeacher(@RequestBody Student student) {
		this.studentService.addStudent(student.getEmail(), student.getFirstName(), student.getLastName(), student.getMarks());
	}
	
	@ExceptionHandler
	ResponseEntity<ExceptionResponse> exceptionhandler(Exception e) {
		
		ExceptionResponse exceptionResponse = new ExceptionResponse();
		
		exceptionResponse.setStatus(HttpStatus.BAD_REQUEST.value());
		exceptionResponse.setMessage("Incorrect URL");
		exceptionResponse.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}
	
	
}
