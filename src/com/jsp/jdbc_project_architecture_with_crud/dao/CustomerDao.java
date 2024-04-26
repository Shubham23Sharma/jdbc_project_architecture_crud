package com.jsp.jdbc_project_architecture_with_crud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jsp.jdbc_project_architecture_with_crud.connnection.CustomerConnection;
import com.jsp.jdbc_project_architecture_with_crud.dto.Customer;

/**
 * @author Shubham Sharma
 * 
 */
public class CustomerDao {

	Connection connection = CustomerConnection.getCustomerConnection();

	/**
	 * 
	 * @param customer
	 * @return
	 * 
	 *         saveCustomerDao(Customer customer) method
	 *         This method will save the customer into our databse
	 */

	public Customer saveCustomerDao(Customer customer) {

		String insertCustomerQuery = "insert into customer values(?,?,?,?,?) ";
		try {
			PreparedStatement ps = connection.prepareStatement(insertCustomerQuery);
			ps.setInt(1, customer.getId());
			ps.setString(2, customer.getName());
			ps.setString(3, customer.getEmail());
			ps.setLong(4, customer.getPhone());
			ps.setString(5, customer.getAddress());
			ps.execute();
			return customer;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 
	 * @return
	 * 
	 * This method will fetch all the details of customer
	 */

	public List<Customer> getAllCustomerDao() {

		String selectQuery = "select * from customer";
		try {
			PreparedStatement ps = connection.prepareStatement(selectQuery);
			ResultSet resultSet = ps.executeQuery();

			List<Customer> customers = new ArrayList<Customer>();
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				String email = resultSet.getString("email");
				long phone = resultSet.getLong("phone");
				String address = resultSet.getString("address");

				Customer customer = new Customer(id, name, phone, email, address);
				customers.add(customer);

			}
			return customers;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 
	 * @param id
	 * @return
	 * 
	 * This method will delete a customer by id
	 */
	public int deleteCustomerByID(int id) {
		String deleteQuery = "delete from customer where id = ?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);
			preparedStatement.setInt(1, id);
			return preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	/**
	 * 
	 * 
	 * @param id
	 * @return
	 * 
	 * This method display a particular customer according to id
	 */
	public List<Customer> displayCustomerByIDDao(int id) {
		String displayQueryById = "select * from customer where id=?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(displayQueryById);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			List<Customer> customers = new ArrayList<Customer>();
			while (resultSet.next()) {
				int idd = resultSet.getInt("id");
				String name = resultSet.getString("name");
				String email = resultSet.getString("email");
				long phone = resultSet.getLong("phone");
				String address = resultSet.getString("address");
				Customer customer = new Customer(idd, name, phone, email, address);
				customers.add(customer);
			}
			return customers;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 
	 * @param id
	 * @param name
	 * @return
	 * 
	 * This method updates the customer name 
	 */
	public int updateCustomerDao(int id, String name) {
		String updateQuery = "update customer set name=? where id = ?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
			preparedStatement.setString(1, name);
			preparedStatement.setInt(2, id);
			return preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * 
	 * @param email
	 * @param id
	 * @return
	 * This method updates the customer email
	 */
	public int updateCustomerDao(String email, int id) {
		String updateQuery = "update customer set email=? where id = ?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
			preparedStatement.setString(1, email);
			preparedStatement.setInt(2, id);
			return preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	/**
	 * 
	 * @param id
	 * @param phone
	 * @return
	 * This method updates the customer email
	 */

	public int updatePhoneDao(int id, long phone) {
		String updateQuery = "update customer set phone=? where id = ?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
			preparedStatement.setLong(1, phone);
			preparedStatement.setInt(2, id);
			return preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	/**
	 * 
	 * @param id
	 * @param address
	 * @return
	 * This method updates the customer address
	 */
	public int updateAddressDao(int id, String address) {
		String updateQuery = "update customer set address=? where id = ?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
			preparedStatement.setString(1, address);
			preparedStatement.setInt(2, id);
			return preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
}
