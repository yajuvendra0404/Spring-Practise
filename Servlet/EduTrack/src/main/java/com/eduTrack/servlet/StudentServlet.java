package com.eduTrack.servlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import com.eduTrack.connection.DBConnection;
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Connection con; 
    public StudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String city = request.getParameter("city");
		try {
			con = DBConnection.getDBConnection(getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		} 
		if (con != null) {
			
	        String queryString = "insert into student values(?,?,?,?)";
			try {
				
				PreparedStatement ps = con.prepareStatement(queryString);
				
				ps.setInt(1, 1);
				ps.setString(2, name);
				ps.setString(3, email);
				ps.setString(4, city);
				
				int result = ps.executeUpdate();
				System.out.println("----- number of rows updated ----"+ result);
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}  else {
			System.out.println("-- connnection issue -- ");
		}
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
		System.out.println("----go doPost method works -----"+ request);
	}

}
