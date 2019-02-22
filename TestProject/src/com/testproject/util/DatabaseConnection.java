package com.testproject.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import com.testproject.model.UserInfo;


public class DatabaseConnection {

	public static Connection EstablishConnection() {
		Connection connection = null;
		try {

			Class.forName(Constants.DB_Driver);
			connection = DriverManager.getConnection(Constants.DB_ConnectionURL, Constants.DBUserNaame,
					Constants.DBPassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	
	public static int executeStatementWithConnectionAndQuery(Connection conection, String Query) {
		int result = 0;
		Statement statement = null;
		try {
			statement = conection.createStatement();
			result = statement.executeUpdate(Query);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;

	}
	public static ResultSet getDataFromDatabaseWithConnection(Connection conection, String Query,
			UserInfo adminUserInfo) {
		ResultSet resultSet = null;
		try {
			
			PreparedStatement preparedStatement = conection.prepareStatement(Query);

			
			preparedStatement.setString(1, adminUserInfo.getMailId());

			
			resultSet = preparedStatement.executeQuery();

			
			

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		return resultSet;
		
	}
}
