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

public class TeacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TeacherServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append(" Form Submited ").append(request.getContextPath());

		System.out.println("----go doGet method works -----");
		
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		
		System.out.println("\n email = "+ email);
		System.out.println("\n address = "+ address);
		System.out.println("\n city = "+ city);
		}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		System.out.println("----go doPost method works -----");
	}

}
