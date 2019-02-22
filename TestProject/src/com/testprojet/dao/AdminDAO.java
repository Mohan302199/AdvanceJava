package com.testprojet.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.testproject.model.UserInfo;
import com.testproject.util.DatabaseConnection;

public class AdminDAO {
	
	public int addAdminToDatabase(UserInfo userInfo) {
		
		Connection connection = DatabaseConnection.EstablishConnection();
		String query = "INSERT INTO admin_user (username,email,password) VALUES('" + userInfo.getUserName() + "','"
				+ userInfo.getMailId() + "','" + userInfo.getPassword() + "');";
	
		return DatabaseConnection.executeStatementWithConnectionAndQuery(connection, query);
	}
	
public ArrayList<UserInfo> loginToDataBase(UserInfo adminUserInfo) {
		
		Connection connection = DatabaseConnection.EstablishConnection();

		String query = "SELECT Email,Password FROM admin_user WHERE Email =?";

		
		ResultSet result = DatabaseConnection.getDataFromDatabaseWithConnection(connection, query, adminUserInfo);
		ArrayList<UserInfo> arryList = new ArrayList<UserInfo>();
		try {
			
			while(result.next()) {
				
				UserInfo adminUserInfoFromDatabase = new UserInfo();
				
				adminUserInfoFromDatabase.setMailId(result.getString("Email"));
				
				adminUserInfoFromDatabase.setPassword(result.getString("Password"));
				
				arryList.add(adminUserInfoFromDatabase);
				
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return arryList;
	}

}
