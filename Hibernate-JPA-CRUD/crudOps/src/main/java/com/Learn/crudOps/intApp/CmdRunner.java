package com.Learn.crudOps.intApp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.Learn.crudOps.Entity.Student;


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
		/* Adding new student. */
		studentService.addStudent(); 
		
		/* Finding one student by its ID. */
//		System.out.println(studentService.fetchStudent());
		
		/* Fetching all student at once and displaying there data on the 
		 * console using Iterator Interface and Iterator() in ArrayList Class. */
		
//		ArrayList<Student> arraydata = (ArrayList<Student>)studentService.fetchAllStudent(); 
//		Iterator<Student> iterator = arraydata.iterator();
//		while(iterator.hasNext()) {
//			System.out.println(" - "+ iterator.next());
//		}
//		
		/* Fetching all student at once and displaying there data on the 
		 * console using "forEach" loop. */
		
//		List<Student> listdata = studentService.fetchAllStudent();
//		for (Student st: listdata) {
//			System.out.println("-"+ st);
//		}
		
		/* Fetching student by last name and displaying there data on the 
		 * console using  "forEach"  loop. */
		
//		List<Student> studentDataByLName =studentService.findByLastName();
//		for (Student st: studentDataByLName) {
//			System.out.println("-"+ st);
//		}
		
		
		/* Fetching student by last name and displaying there data on the 
		 * console using Iterator Interface and Iterator() in ArrayList Class. */
		
//		ArrayList<Student> studentDataByLName = (ArrayList<Student>)studentService.findByLastName(); 
//		Iterator<Student> iterator = studentDataByLName.iterator();
//		while(iterator.hasNext()) {
//			System.out.println(" - "+ iterator.next());
//		}
		
		/* update student. */
		
//		studentService.updateStudent(3);
		
		/* Delete student. */
		
		studentService.deleteStudent(5);
		
		
		
		
		
		
	}
	
}
