package com.bridgelabz.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConfiguration {
	
	final String CONNECTION_URL="jdbc:mysql://localhost:3306/employee_info";
	
	final String USER_NAME = "root";
	
	final String PASSWORD = "Rahul@123";

			
	public Connection getConnection() {
		Connection connection =null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(CONNECTION_URL, USER_NAME, PASSWORD);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
	

}
