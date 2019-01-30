package com.princessvilla.controller;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.princessvilla.model.*;

@WebServlet("/AddAdmin")
public class AddAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Object Creation
		
		AdminUserInfo adminUserInfo = new AdminUserInfo();
		adminUserInfo.setUserName(request.getParameter("userName"));
		adminUserInfo.setEmailAddress(request.getParameter("emailAddress"));
		adminUserInfo.setPassword(request.getParameter("password"));
		adminUserInfo.setAuthToken(request.getParameter("authToken"));
		
	}

}
