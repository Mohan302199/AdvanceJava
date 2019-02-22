package com.testproject.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.testproject.model.UserInfo;
import com.testproject.service.AddAdminService;


@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public loginServlet() {
        super();
    }
        
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserInfo userInfo = new UserInfo();
		userInfo.setMailId(request.getParameter("email"));
		userInfo.setPassword(request.getParameter("password"));
		 AddAdminService addAdminService = new AddAdminService();
		 boolean login = addAdminService.loginAuth(userInfo);
		
		 if(login == true) {
			 System.out.println("Login successful");
			 response.sendRedirect("loginsuccess.jsp");
		 }else
		 {
			System.out.println("Password Error"); 
			request.setAttribute("errorMessage", "Database error");
			request.getRequestDispatcher("login.jsp").forward(request,response);
		 }
		 
		doGet(request, response);
	}

}
