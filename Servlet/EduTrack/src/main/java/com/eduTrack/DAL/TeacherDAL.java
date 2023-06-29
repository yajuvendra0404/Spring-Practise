package com.eduTrack.DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.eduTrack.connection.DBConnection;

import jakarta.servlet.ServletContext;

public class TeacherDAL {

    private Connection con; 
	
	public TeacherDAL (ServletContext context) {
		try {
			con = DBConnection.getDBConnection(context);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	public ResultSet getTeacherByEmail (String email) {
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
