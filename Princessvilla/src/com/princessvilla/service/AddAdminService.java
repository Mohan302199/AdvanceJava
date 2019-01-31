package com.princessvilla.service;

import com.princessvilla.dao.AdminDAO;
import com.princessvilla.model.AdminUserInfo;
import com.princessvilla.util.Constants;

public class AddAdminService {
	
	public void addAdminInService (AdminUserInfo adminUserInfo) {
		
		
		if(adminUserInfo.getAuthToken().equals(Constants.authToken)) {
			System.out.println("Data Stored To database");
			AdminDAO adminDAO = new AdminDAO();
			adminDAO.addAdminToDAtabase(adminUserInfo);
		}else {
			System.out.println("Sorry !! your Auth Token is wrong");
		}
		
		
	}

}
