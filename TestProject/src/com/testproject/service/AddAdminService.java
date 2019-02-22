package com.testproject.service;

import java.util.ArrayList;


import com.testproject.model.UserInfo;
import com.testproject.util.*;
import com.testprojet.dao.AdminDAO;


public class AddAdminService {

	public int addAdminInService(UserInfo userInfo) {
		if(userInfo.getAuthToken().equals(Constants.authtoken)) {
			System.out.println("Authtoken is right");
			AdminDAO admindao = new AdminDAO();
			return admindao.addAdminToDatabase(userInfo);
		}else
		{
			System.out.println("Authtoken is wrong");
			return 2;
		}
	}
	
	public boolean loginAuth(UserInfo userInfo) {
AdminDAO adminDAO = new AdminDAO();
		
		ArrayList<UserInfo> arraylist= new ArrayList<UserInfo>();
		arraylist= (adminDAO.loginToDataBase(userInfo));
		boolean valid =false;
		
		for(UserInfo adminUserInfo2:arraylist) {
			
			if(((userInfo.getMailId()).equals(adminUserInfo2.getMailId()))  && ( ((userInfo.getPassword()).equals(adminUserInfo2.getPassword()) ))){
				
				
				return true;
			}else {
				return false;
			}
		}
		return false;

	}
}
