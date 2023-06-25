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
			String queryString = "select * from students";
			PreparedStatement ps =con.prepareStatement(queryString);
			resultObject = ps.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultObject;
	}
	
	public boolean addStudent (StudentModel student) {
			boolean result = false;
	        String queryString = "insert into students (name, email, city) values (?,?,?)";
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
		String queryString = "delete from students where id = ?";
		try {
			
			ResultSet rs = this.getStudentByEmail(email);
			PreparedStatement ps = con.prepareStatement(queryString);
			ps.setInt(1, rs.getInt("id"));
			
		    if(ps.executeUpdate() > 0) result = true;
		    else result = false;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public ResultSet getStudentByEmail (String email) {
		ResultSet resultSet = null;
		String queryString = "select * from students where email = ?";
		try {
			PreparedStatement ps = con.prepareStatement(queryString);
			ps.setString(1, email);
			resultSet = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultSet;
	}

}
