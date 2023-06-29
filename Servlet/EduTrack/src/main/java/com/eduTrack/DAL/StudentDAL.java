package com.eduTrack.DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.eduTrack.connection.DBConnection;
import com.eduTrack.model.StudentModel;

import jakarta.servlet.ServletContext;

public class StudentDAL {
	
    private Connection con; 
	
	public StudentDAL (ServletContext context) {
		
		try {
			con = DBConnection.getDBConnection(context);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}
	
	public ResultSet getALLStudent () {
		ResultSet resultObject = null; 
		try {
			
			String queryString = "SELECT * FROM students";
			PreparedStatement ps =con.prepareStatement(queryString);
			resultObject = ps.executeQuery();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultObject;
	}
	
	public boolean addStudent (StudentModel student) {
		
			boolean result = false;
	        String queryString = "INSERT INTO students (name, email, city) VALUES (?,?,?)";
			try {
				
			    PreparedStatement ps = con.prepareStatement(queryString, Statement.RETURN_GENERATED_KEYS);
			    ps.setString(1, student.getName());
			    ps.setString(2, student.getEmail());
			    ps.setString(3, student.getCity());
			    if(ps.executeUpdate() > 0) result = true;
			    else result = false;

				System.out.println("----- number of rows updated ----"+ result);
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return result;

	}
	
	public boolean deleteStudent(String email) {
		
		boolean result = false;
		String queryString = "DELETE FROM students WHERE email = ?";
		
		try {
			
			PreparedStatement ps = con.prepareStatement(queryString);
			ps.setString(1, email);
		    if(ps.executeUpdate() > 0) result = true;
		    else result = false;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public ResultSet getStudentByEmail (String email) {
		ResultSet resultSet = null;
		String queryString = "SELECT * FROM students WHERE email = ?";
		
		try {
			
			PreparedStatement ps = con.prepareStatement(queryString);
			ps.setString(1, email);
			resultSet = ps.executeQuery();
			System.out.println(" --- next --- ");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultSet;
	}

}
