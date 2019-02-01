package com.princessvilla.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.princessvilla.model.AdminUserInfo;
import com.princessvilla.service.AddAdminService;

@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());

		AdminUserInfo loginUserInfo = new AdminUserInfo();
		loginUserInfo.setEmailAddress(request.getParameter("loginuserid"));
		loginUserInfo.setPassword(request.getParameter("loginpassword"));

		AddAdminService addAdminService = new AddAdminService();
		addAdminService.loginAuthentication(loginUserInfo);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
