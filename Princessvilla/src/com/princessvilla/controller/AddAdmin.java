package com.princessvilla.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.princessvilla.model.*;
import com.princessvilla.service.AddAdminService;

@WebServlet("/AddAdmin")
public class AddAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		AdminUserInfo adminUserInfo = new AdminUserInfo();
		adminUserInfo.setUserName(request.getParameter("userName"));
		adminUserInfo.setEmailAddress(request.getParameter("emailAddress"));
		adminUserInfo.setPassword(request.getParameter("password"));
		adminUserInfo.setAuthToken(request.getParameter("authToken"));

		AddAdminService addAdminService = new AddAdminService();
		int wasStoredInDB = addAdminService.addAdminInService(adminUserInfo);
		if (wasStoredInDB == 1) {
			response.sendRedirect("success.jsp");
		} else if (wasStoredInDB == 0) {
			request.setAttribute("wasStoredInDB", "Database Error");
			request.getRequestDispatcher("admin.jsp").forward(request, response);
		} else if (wasStoredInDB == 2) {
			request.setAttribute("wasStoredInDB", "Authentication Token Error");
			request.getRequestDispatcher("admin.jsp").forward(request, response);
		}

	}

}
