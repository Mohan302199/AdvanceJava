package com.princessvilla.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.princessvilla.model.AdminUserInfo;

public class DataBAseConnection {

	public static Connection EstablishConnection() {
		Connection connection = null;
		try {

			Class.forName(Constants.DB_Driver);
			connection = DriverManager.getConnection(Constants.DB_ConnectionURL, Constants.DB_UserId,
					Constants.DB_Password);
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
			AdminUserInfo adminUserInfo) {
		ResultSet resultSet = null;
		try {
			System.out.println("getDataFromDatabaseWithConnection1");
			PreparedStatement preparedStatement = conection.prepareStatement(Query);

			System.out.println("getDataFromDatabaseWithConnection2");
			preparedStatement.setString(1, adminUserInfo.getEmailAddress());

			System.out.println("getDataFromDatabaseWithConnection3");
			resultSet = preparedStatement.executeQuery();

			System.out.println("getDataFromDatabaseWithConnection4");
			

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		return resultSet;
		
	}
}
