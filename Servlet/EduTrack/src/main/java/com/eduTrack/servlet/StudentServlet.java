package com.eduTrack.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

import com.eduTrack.appUtils.AppUtils;

import com.eduTrack.service.StudentService;
import com.eduTrack.appUtils.ResponseMessage;


public class StudentServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    private StudentService studentService ;
    
    public StudentServlet() { }

    @Override
    public void init() throws ServletException {
        super.init();
        studentService = new StudentService(getServletContext());
    }
    
    /* 
     * Get List Of all students
     * http://localhost:8080/EduTrack/student 
     */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			AppUtils.sendResponseJson(response, 
					this.studentService.getALLStudent()
			);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
 
	
	
    /* 
     * Add new student
     * http://localhost:8080/EduTrack/student 
     * {
     * 	email: String
	 * 	name: String 
     * 	city: String
     * }
     */
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ResponseMessage messageJson = this.studentService.addStudent(
				request.getParameter("name"), 
				request.getParameter("email"), 
				request.getParameter("city")
		);
				
		AppUtils.sendResponseJson(response, messageJson);
	}

	
	/* 
     * Delete student by giving email Id of that student
     * http://localhost:8080/EduTrack/student 
     * {
     * 	email: String
     * }
     */
	protected void doDelete (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ResponseMessage messageJson = this.studentService.deleteStudent(
				request.getParameter("email")
		);
		AppUtils.sendResponseJson(response, messageJson );
	}
	
	protected void doPut (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	
}
