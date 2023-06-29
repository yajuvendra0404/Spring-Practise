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
    private StudentDAL studentDAL;
    private StudentModel studentModel;
    private ResponseMessage message; 
    
    
	public StudentService (ServletContext context) {
		this.studentModel = new StudentModel();
		this.studentDAL = new StudentDAL(context);

	}
    
    
	public List<StudentModel> getALLStudent( ) throws SQLException {
		
		ResultSet resultObject = this.studentDAL.getALLStudent();
		List<StudentModel> responseData= new ArrayList<>();
		while (resultObject.next()) {
			StudentModel row = new StudentModel(resultObject.getString("name"), resultObject.getString("email"), resultObject.getString("city") );
			responseData.add(row);
		}
		return responseData;
		
	}

	
	public ResponseMessage addStudent (String name, String email, String city) {
		
		this.studentModel.setName(name);
		this.studentModel.setEmail(email);
		this.studentModel.setCity(city);
		
		if(this.studentDAL.addStudent(this.studentModel)) {
			this.message = new ResponseMessage( 200, "Student Added Successfully");
		} else {
			this.message = new ResponseMessage( 200, "Error Occured while adding student");
		}
		
		return this.message;
	}
	
	
	public ResponseMessage deleteStudent(String email) {

		if(this.studentDAL.deleteStudent(email)) {
			this.message = new ResponseMessage( 200, "student deleted");
		} else {
			this.message = new ResponseMessage( 200, "Error Occured while deleting student");
		}
		return message;
		
	}

}
