package com.princessvilla.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.princessvilla.model.AdminUserInfo;
import com.princessvilla.util.Constants;
import com.princessvilla.util.DataBAseConnection;

public class AdminDAO {

	public int addAdminToDAtabase(AdminUserInfo adminUserInfo) {

		Connection connection = DataBAseConnection.EstablishConnection();

		String query = "INSERT INTO admin_user (UserId,Email,Password) VALUES('" + adminUserInfo.getUserName() + "','"
				+ adminUserInfo.getEmailAddress() + "','" + adminUserInfo.getPassword() + "');";

		return (DataBAseConnection.executeStatementWithConnectionAndQuery(connection, query));
	}

	public ArrayList<AdminUserInfo> loginToDataBase(AdminUserInfo adminUserInfo) {
		
		Connection connection = DataBAseConnection.EstablishConnection();

		String query = "SELECT Email,Password FROM admin_user WHERE Email =?";

		
		ResultSet result = DataBAseConnection.getDataFromDatabaseWithConnection(connection, query, adminUserInfo);
		ArrayList<AdminUserInfo> arryList = new ArrayList<AdminUserInfo>();
		try {
			
			while(result.next()) {
				
				AdminUserInfo adminUserInfoFromDatabase = new AdminUserInfo();
				
				adminUserInfoFromDatabase.setEmailAddress(result.getString("Email"));
				
				adminUserInfoFromDatabase.setPassword(result.getString("Password"));
				
				arryList.add(adminUserInfoFromDatabase);
				
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return arryList;
	}

}
