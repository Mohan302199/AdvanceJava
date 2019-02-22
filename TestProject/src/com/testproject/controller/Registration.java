package com.testproject.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.testproject.model.UserInfo;
import com.testproject.service.*;


@WebServlet("/Registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public Registration() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserInfo userInfo = new UserInfo();
		userInfo.setUserName(request.getParameter("username"));
		userInfo.setMailId(request.getParameter("email"));
		userInfo.setPassword(request.getParameter("password"));
		userInfo.setAuthToken(request.getParameter("authtoken"));
		
		AddAdminService addAdminService = new AddAdminService();
		int hassighup = addAdminService.addAdminInService(userInfo);
		if(hassighup ==1 ) {
			response.sendRedirect("login.jsp");
		}else {
			request.setAttribute("errorMessage", "Database error");
			request.getRequestDispatcher("default.jsp").forward(request,response);
		}
		doGet(request, response);
	}

}
