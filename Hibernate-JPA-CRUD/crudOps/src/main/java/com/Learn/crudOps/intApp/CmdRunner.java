package com.Learn.crudOps.intApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


import com.Learn.crudOps.service.StudentService;

@Component
public class CmdRunner implements CommandLineRunner{
	
	StudentService studentService;
	
	@Autowired
	public CmdRunner (StudentService studentService) {
		this.studentService = studentService;
	}
	
	@Override
	public void run (String ...args) throws Exception {
		System.out.println("-------CMD Line Runner -----");
		studentService.addStudent();
	}
	
}
