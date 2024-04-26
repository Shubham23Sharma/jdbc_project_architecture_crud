package com.jsp.jdbc_project_architecture_with_prepared_statement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jsp.jdbc_project_architecture_with_prepared_statement.connnection.PhoneConnection;
import com.jsp.jdbc_project_architecture_with_prepared_statement.dto.Phone;

public class PhoneDao {
	
	Connection connection=PhoneConnection.getPhoneConnection();
	
	
	
	public Phone savePhoneDao(Phone phone) {
		
		String insertQuery="insert into phone values(?,?,?,?,?,?)";
		
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(insertQuery);
			preparedStatement.setInt(1, phone.getId());
			preparedStatement.setString(2, phone.getName());
			preparedStatement.setLong(3, phone.getImeino());
			preparedStatement.setString(4, phone.getRam());
			preparedStatement.setString(5, phone.getCamera());
			preparedStatement.setString(6, phone.getColor());
			preparedStatement.execute();
			return phone;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Phone> getAllPhoneDao()
	{
		String displayQuery = "select * from phone";
		try {
			PreparedStatement preparedStatement =connection.prepareStatement(displayQuery);
			ResultSet resultSet  = preparedStatement.executeQuery();
			List<Phone> phone = new ArrayList<Phone>();
			while(resultSet.next())
			{
				int id=resultSet.getInt("id");
				String name=resultSet.getString("name");
				long imeino=resultSet.getLong("imeino");
				String ram=resultSet.getString("ram");
				String camera=resultSet.getString("camera");
				String color=resultSet.getString("color");
				
				
				Phone phones = new Phone(id, name, imeino, ram, camera, color);
				phone.add(phones);
			}
			return phone;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
