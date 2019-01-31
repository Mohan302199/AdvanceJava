package com.princessvilla.dao;

import java.sql.Connection;

import com.princessvilla.model.AdminUserInfo;
import com.princessvilla.util.Constants;
import com.princessvilla.util.DataBAseConnection;

public class AdminDAO {

		public void addAdminToDAtabase(AdminUserInfo adminUserInfo) {
			 
			Connection connection = DataBAseConnection.EstablishConnection();
			
			String query ="INSERT INTO admin_user (UserId,Email,Password) VALUES('"+adminUserInfo.getUserName()+"','"+adminUserInfo.getEmailAddress()+"','"+adminUserInfo.getPassword()+"');";
			
		
		
		DataBAseConnection.executeStatementWithConnectionAndQuery(connection,query);
		}
}
