package com.princessvilla.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DataBAseConnection {
	
	public static Connection EstablishConnection() {
		
		System.out.println("Starting EstablishCOnnection");
		Connection connection = null;
	try {
		
		Class.forName(Constants.DB_Driver);
		System.out.println("Pasiing database credentials");
		connection = DriverManager.getConnection(Constants.DB_ConnectionURL,Constants.DB_UserId,Constants.DB_Password);
		System.out.println("Exiting EstablishConnection");
		
	}catch(Exception e) {
		System.out.println("Exception for Establishing Connection to Database");
		e.printStackTrace();
	}
	return connection;
	
}
	public static int executeStatementWithConnectionAndQuery(Connection conection, String Query) {
		int result =0;
		Statement statement = null;
		try {
			statement = conection.createStatement();
			result = statement.executeUpdate(Query);
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
		
		
	}
}
