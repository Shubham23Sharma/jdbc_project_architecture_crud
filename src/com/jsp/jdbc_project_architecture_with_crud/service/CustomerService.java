package com.jsp.jdbc_project_architecture_with_crud.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.jsp.jdbc_project_architecture_with_crud.dao.CustomerDao;
import com.jsp.jdbc_project_architecture_with_crud.dto.Customer;

public class CustomerService {

	Scanner sc = new Scanner(System.in);
	CustomerDao customerDao = new CustomerDao();
	
	/**
	 * 
	 * @param customer
	 * @return
	 * This method will save the customer if id is less than equal to 4 digit
	 */

	public Customer saveCustomerService(Customer customer) {

		if (customer.getId() < 10000) {
			System.out.println("Data Updated");
			return customerDao.saveCustomerDao(customer);
		} else {
			System.out.println("Please enter id Less than equal to 4 digit");
		}
		return null;
	}
	
	/**
	 * 
	 * @return
	 * This method will fetch all the customers
	 */

	public List<Customer> getAllCustomerService() {
		return customerDao.getAllCustomerDao();
	}

	/**
	 * 
	 * @param id
	 * @return
	 * This method will delete customer by id
	 */
	public int getDeleteByIdService(int id) {

		return customerDao.deleteCustomerByID(id);
	}
	/**
	 * 
	 * @param address
	 * @return
	 * This method will filter the data according to address
	 */
	
	public List<Customer> filterCustomerByAdress(String address) {
		List<Customer> filterCustomer = new ArrayList<Customer>();
		List<Customer> customer = customerDao.getAllCustomerDao();
		for (Customer customer2 : customer) {
			if (customer2.getAddress().equalsIgnoreCase(address)) {
				filterCustomer.add(customer2);
			}
		}
		return filterCustomer;

	}
	/**
	 * 
	 * @param id
	 * @return
	 * This method is used to display customer by id
	 */

	public List<Customer> displayCustomerByIDService(int id) {
		return customerDao.displayCustomerByIDDao(id);
	}

	/**
	 * 
	 * @param id
	 * @param phone
	 * @return
	 * This method is used to update phone
	 */
	public int updatePhoneService(int id, long phone) {
		return customerDao.updatePhoneDao(id, phone);
	}
	
	/**
	 * 
	 * @param id
	 * @param address
	 * @return
	 * This method is used to update addess
	 */
	public int updateAddressService(int id, String address) {
		return customerDao.updateAddressDao(id, address);
	}

	/**
	 * 
	 * @param email
	 * @param id
	 * @return
	 * This method is used to update email
	 */
	public int updateCustomerService(String email, int id) {
		return customerDao.updateCustomerDao(email, id);
	}

	/**
	 * 
	 * @param id
	 * @param name
	 * @return
	 * This method is used to update name
	 */
	public int updateCustomerService(int id, String name) {
		return customerDao.updateCustomerDao(id, name);
	}

}
