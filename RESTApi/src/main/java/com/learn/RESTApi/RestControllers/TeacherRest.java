package com.learn.RESTApi.RestControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.learn.RESTApi.Models.Teacher;
import com.learn.RESTApi.Services.TeacherService;

@RestController
@RequestMapping("/teacher")
public class TeacherRest {

	private TeacherService teacherService;
	
	@Autowired
	public TeacherRest ( 
			@Qualifier("TeacherService") TeacherService teacherService
	) {
		this.teacherService = teacherService;
	}
	
	/* Rest API to fetch all Teacher */
	@GetMapping("/")
	public List<Teacher> getAllStudent() {
		return this.teacherService.getAllTeacher();
	}
	
	/*Rest API to fetch one Teacher by Id of that Teacher */
	@GetMapping("/{id}")
	public Teacher getTeacherById (@PathVariable int id) {
		return this.teacherService.getTeacherById(id);
	}
	
	/*Rest API for adding new teacher to the database*/
	@PostMapping("/{email}/{firstName}/{lastName}/{module}")
	public void addTeacher(@PathVariable String email , @PathVariable String firstName , @PathVariable String lastName, @PathVariable String module ) {
		this.teacherService.addTeacher(email, firstName, lastName, module);
	}	
}
