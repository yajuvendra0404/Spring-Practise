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
	private StudentEntity studentEntity;
	private Student studentModel;
	@Autowired
	public StudentService (
			@Qualifier("StudentDAO") IStudentDAO studentDAOImpl,
			@Qualifier("StudentEntity") StudentEntity studentEntity,
			@Qualifier("StudentModel") Student studentModel
	) {
		this.studentDAO = studentDAOImpl;
		this.studentEntity = studentEntity;
		this.studentModel = studentModel;
	}
	
	public void addStudent(String firstName, String lastName, String email, int marks ) {
		
		studentEntity.setEmail(email);
		studentEntity.setFirstName(firstName);
		studentEntity.setLastName(lastName);
		studentEntity.setMarks(marks);
		
		studentDAO.save(studentEntity);
	}
	
	public List<Student> getAllStudent() {
		List<StudentEntity> studentEntityData = studentDAO.getAllStudent();
		List<Student> studentModelData = new ArrayList<Student>();

		Iterator<StudentEntity> itr = studentEntityData.iterator();
		
		while(itr.hasNext()) {	
			
			this.studentModel.setMarks(itr.next().getMarks());
			this.studentModel.setFirstName(itr.next().getFirstName());
			this.studentModel.setLastName(itr.next().getLastName());
			this.studentModel.setEmail(itr.next().getEmail());
			
			studentModelData.add(this.studentModel);
		} 
		
		return  studentModelData;
	}
	
	public List<Student> getStudentByID(int id) {
		return  null;
//		return studentDAO.getStudentById(id);
	}
	
}
