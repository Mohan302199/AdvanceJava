package com.princessvilla.service;

import com.princessvilla.model.AdminUserInfo;
import com.princessvilla.util.Constants;

public class AddAdminService {
	
	public void addAdminInService (AdminUserInfo adminUserInfo) {
		String authToken = Constants.authToken;
		
		if(adminUserInfo.getAuthToken().equals(Constants.authToken)) {
			System.out.println("Data Stored To database");
		}else {
			System.out.println("Sorry !! your Auth Token is wrong");
		}
		
		
	}

}
