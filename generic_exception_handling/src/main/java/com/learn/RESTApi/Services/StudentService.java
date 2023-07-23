package com.learn.RESTApi.Services;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.learn.RESTApi.DAOs.Student.IStudentDAO;
import com.learn.RESTApi.Entities.StudentEntity;
import com.learn.RESTApi.Models.Student;

@Service
@Qualifier("StudentService")
public class StudentService {
	private IStudentDAO studentDAO;
	private Student studentModel = new Student();
	@Autowired
	public StudentService (
			@Qualifier("StudentDAO") IStudentDAO studentDAOImpl
	) {
		this.studentDAO = studentDAOImpl;
	}
	
	public void addStudent(String firstName, String lastName, String email, int marks ) {
		
		studentModel.setEmail(email);
		studentModel.setFirstName(firstName);
		studentModel.setLastName(lastName);
		studentModel.setMarks(marks);
		
		studentDAO.save(studentModel);
	}
	
	public List<Student> getAllStudent() {

		List<Student> studentModelData = new ArrayList<Student>();

		Iterator<StudentEntity> itr = studentDAO.getAllStudent().iterator();
		
		while(itr.hasNext()) {	
			StudentEntity dataRow = itr.next();
			
			this.studentModel.setMarks(dataRow.getMarks());
			this.studentModel.setFirstName(dataRow.getFirstName());
			this.studentModel.setLastName(dataRow.getLastName());
			this.studentModel.setEmail(dataRow.getEmail());
			
			studentModelData.add(this.studentModel);
		} 
		
		return  studentModelData;
	}
	
	public Student getStudentByID(int id) {
		Student student = new Student();
		Iterator<StudentEntity> itr = studentDAO.getStudentById(id).iterator();
		StudentEntity rowData = itr.next();
		
		student.setEmail(rowData.getEmail());
		student.setFirstName(rowData.getFirstName());
		student.setLastName(rowData.getLastName());
		student.setMarks(rowData.getMarks());
		
		return  student;
//		return studentDAO.getStudentById(id);
	}
	
}
