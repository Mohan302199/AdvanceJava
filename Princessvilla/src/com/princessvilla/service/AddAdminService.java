package com.princessvilla.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.princessvilla.dao.AdminDAO;
import com.princessvilla.model.AdminUserInfo;
import com.princessvilla.util.Constants;

public class AddAdminService {

	public int addAdminInService(AdminUserInfo adminUserInfo) {

		if (adminUserInfo.getAuthToken().equals(Constants.authToken)) {

			AdminDAO adminDAO = new AdminDAO();
			return (adminDAO.addAdminToDAtabase(adminUserInfo));
		} else {
			return 2;
		}

	}

	public boolean loginAuthentication(AdminUserInfo adminUserInfo) {
		System.out.println("loginAuthentication");
		AdminDAO adminDAO = new AdminDAO();
		
		ArrayList<AdminUserInfo> arraylist= new ArrayList<AdminUserInfo>();
		arraylist= (adminDAO.loginToDataBase(adminUserInfo));
		boolean valid =false;
		
		for(AdminUserInfo adminUserInfo2:arraylist) {
			System.out.println(adminUserInfo2.getEmailAddress());
			if(((adminUserInfo.getEmailAddress()).equals(adminUserInfo2.getEmailAddress()))  && ( ((adminUserInfo.getPassword()).equals(adminUserInfo2.getPassword()) ))){
				
				System.out.println("Passed");
				return true;
			}else {
				System.out.println("Failed");
			}
		}
		return false;

		

	}

}
