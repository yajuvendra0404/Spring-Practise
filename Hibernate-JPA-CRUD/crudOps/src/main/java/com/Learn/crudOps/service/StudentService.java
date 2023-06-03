package com.Learn.crudOps.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Learn.crudOps.DAO.student.IStudentDAO;
import com.Learn.crudOps.Entity.Student;


@Service
public class StudentService  {
	IStudentDAO StudentDAO;
	
	@Autowired
	public StudentService (IStudentDAO StudentDAO) {
		this.StudentDAO = StudentDAO;
	}

	public void addStudent() {
		Student thisStudent = new Student("jackson","huge","jacksonsa@gmail.com");
		System.out.println("----- Data ----"+ thisStudent);
		StudentDAO.save(thisStudent);

	}

}
