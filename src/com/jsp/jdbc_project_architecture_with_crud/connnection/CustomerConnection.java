package com.jsp.jdbc_project_architecture_with_crud.connnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.cj.jdbc.Driver;

/**
 * 
 * @author Shubham Sharma {We have created this class for jdbc connection}
 */
public class CustomerConnection {
	/**
	 * 
	 * @return connection This method create and return connection
	 */
	public static Connection getCustomerConnection() {
		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			String url = "jdbc:mysql://localhost:3306/jdbc";
			String name = "root";
			String pass = "root";
			Connection connection = DriverManager.getConnection(url, name, pass);
			return connection;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
