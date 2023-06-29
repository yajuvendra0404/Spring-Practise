package com.eduTrack.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.eduTrack.DAL.StudentDAL;
import com.eduTrack.DAL.TeacherDAL;
import com.eduTrack.appUtils.ResponseMessage;
import com.eduTrack.model.StudentModel;

import jakarta.servlet.ServletContext;

public class LoginService {
	private StudentDAL studentDAL;
	private TeacherDAL teacherDAL;
	private ResponseMessage message;
	
	
	public LoginService (ServletContext context) {
		this.studentDAL = new StudentDAL(context);
		this.teacherDAL = new TeacherDAL(context);
	}
	
	public ResponseMessage validateUser (String id , String password, String role) {
		ResultSet resultSet = null;  
		boolean isAuthenticated = false;
		
		if(role == "student") {
			resultSet = studentDAL.getStudentByEmail(id); 
		} else {
			resultSet = teacherDAL.getTeacherByEmail(id);
		}

		if(resultSet != null) {
			try {
				String userName = "";
				while(resultSet.next()) {
					userName = resultSet.getString("name");	
				}
				if(userName.equals(password)) isAuthenticated = true;
				
			} catch (SQLException e) {
				this.message = new ResponseMessage( 400, "User Id or Password is wrong.");
				e.printStackTrace();
			}
		}
		if(isAuthenticated) {
			this.message = new ResponseMessage( 200, "User Loggedin Successfully.");
		} else {

			this.message = new ResponseMessage( 400, "User Id or Password is wrong.");
		}

		return this.message;
	}
	
	
}
