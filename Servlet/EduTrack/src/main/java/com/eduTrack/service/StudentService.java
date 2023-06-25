package com.eduTrack.service;

import java.util.ArrayList;
import java.util.List;

import com.eduTrack.DAL.StudentDAL;
import com.eduTrack.appUtils.ResponseMessage;
import com.eduTrack.model.StudentModel;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletContext;

public class StudentService {
	private ServletContext context;
    private StudentDAL studentDAL = new StudentDAL(context);
    private StudentModel studentModel;
    private ResponseMessage message; 
	public StudentService (ServletContext context) {
		this.context = context;
		this.studentModel = new StudentModel();
	}
    
    
	public List<StudentModel> getALLStudent( ) throws SQLException {
		
		ResultSet resultObject = this.studentDAL.getALLStudent();
		List<StudentModel> responseData= new ArrayList<>();
		while (resultObject.next()) {
			StudentModel row = new StudentModel(resultObject.getString("name"), resultObject.getString("email"), resultObject.getString("city") );
			responseData.add(row);
		}
		return  null;
		
	}

	
	public ResponseMessage addStudent (String name, String email, String city) {
		
		this.studentModel.setName(name);
		this.studentModel.setEmail(email);
		this.studentModel.setCity(city);
		
		if(this.studentDAL.addStudent(this.studentModel)) {
			this.message.setMessage("Student Added Successfully");
			this.message.setStatus(200);
		} else {
			this.message.setMessage("Error Occured while adding student");
			this.message.setStatus(400);
		}
		return this.message;
	}
	
	
	public ResponseMessage deleteStudent(String email) {

		if(this.studentDAL.deleteStudent(email)) {
			this.message.setMessage("Student Added Successfully");
			this.message.setStatus(200);
		} else {
			this.message.setMessage("Error Occured while adding student");
			this.message.setStatus(400);
		}
		return message;
		
	}
	
	

}
