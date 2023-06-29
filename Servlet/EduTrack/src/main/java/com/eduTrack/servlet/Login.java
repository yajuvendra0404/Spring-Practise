package com.eduTrack.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.eduTrack.appUtils.AppUtils;
import com.eduTrack.appUtils.ResponseMessage;
import com.eduTrack.service.LoginService;
import com.eduTrack.service.StudentService;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
    private LoginService loginService;
	private static final long serialVersionUID = 1L;
       

    @Override
    public void init() throws ServletException {
        super.init();
        loginService = new LoginService(getServletContext());
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String userType = request.getParameter("userType");
		
		ResponseMessage responseMessage = loginService.validateUser(id, password, userType);
		
		if(responseMessage.getStatus() == 200) response.addCookie( new Cookie("cookie", id ) );
		
		AppUtils.sendResponseJson(response, responseMessage);
	}

}
