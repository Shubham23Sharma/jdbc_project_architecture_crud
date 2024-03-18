package com.jsp.jdbc_project_architecture_with_prepared_statement.connnection;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PhoneConnection {
	
	public static Connection getPhoneConnection() {
		
		try {
			Driver driver = new com.mysql.cj.jdbc.Driver();
			DriverManager.registerDriver(driver);
			
			String url="jdbc:mysql://localhost:3306/jdbc";
			String user = "root";
			String pass = "root";
			
			Connection connection =DriverManager.getConnection(url, user, pass);
			
			return connection;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
