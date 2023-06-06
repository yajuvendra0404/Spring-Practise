package com.Learn.crudOps.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Learn.crudOps.DAO.student.IStudentDAO;
import com.Learn.crudOps.Entity.Student;
import com.Learn.crudOps.enums.SortBy;


@Service
public class StudentService  {
	IStudentDAO StudentDAO;
	
	@Autowired
	public StudentService (IStudentDAO StudentDAO) {
		this.StudentDAO = StudentDAO;
	}

	public void addStudent() {
//		Student thisStudent = new Student("Duke","leach","dleacha@gmail.com");
//		StudentDAO.save(thisStudent);
//		Student thisStudent1 = new Student("Rashid","Ali","Alia@gmail.com");
//		StudentDAO.save(thisStudent1);
//		Student thisStudent2 = new Student("Kim","Doris","kDoris@gmail.com");
//		StudentDAO.save(thisStudent2);
//		Student thisStudent3 = new Student("Pamela","Anderson","pAnderson@gmail.com");
//		StudentDAO.save(thisStudent3);
//		Student thisStudent4 = new Student("Rust","Anderson","Rson@gmail.com");
//		StudentDAO.save(thisStudent4);
		
	}
	
	public Student fetchStudent() {
		return StudentDAO.findById(1);
	}
	
	public List<Student> fetchAllStudent() {
		return StudentDAO.findAll(SortBy.FIRSTNAME);
	}
	
	public List<Student> findByLastName () {
		return StudentDAO.findByLastName("o");
	}
	
	public boolean updateStudent(int studentId) {
		
		Student student = StudentDAO.findById(studentId);
		student.setFirstName("yajuvendra");
		StudentDAO.update(student);
		return false;
	}

	public boolean deleteStudent(int studentId) {
		StudentDAO.delete(studentId);
		return  false;
	}
}
