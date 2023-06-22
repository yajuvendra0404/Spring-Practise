package com.eduTrack.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.eduTrack.connection.DBConnection;
import com.google.gson.Gson;

public class TeacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Connection con;
    
    public TeacherServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			con = DBConnection.getDBConnection(getServletContext());
			String queryString = "select * from teacher";
			PreparedStatement ps =con.prepareStatement(queryString);
			ResultSet resultObject = ps.executeQuery();
			
		    String json = new Gson().toJson(resultObject);
		    response.setContentType("application/json");
		    response.setCharacterEncoding("UTF-8");
		    response.getWriter().write(json);
		    

		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String module = request.getParameter("module");
		try {
			con = DBConnection.getDBConnection(getServletContext());
		} catch (Exception e) {
			e.printStackTrace();
		} 
		if (con != null) {
			
	        String queryString = "insert into teacher (name, email, module) values (?,?,?)";
			try {
				
			    PreparedStatement ps = con.prepareStatement(queryString, Statement.RETURN_GENERATED_KEYS);

			    ps.setString(1, name);
			    ps.setString(2, email);
			    ps.setString(3, module);

			    int result = ps.executeUpdate();

				System.out.println("----- number of rows updated ----"+ result);
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}  else {
			System.out.println("-- connnection issue -- ");
		}

	}

}
