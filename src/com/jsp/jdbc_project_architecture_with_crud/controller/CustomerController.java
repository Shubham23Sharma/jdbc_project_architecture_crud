package com.jsp.jdbc_project_architecture_with_crud.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.jsp.jdbc_project_architecture_with_crud.connnection.CustomerConnection;
import com.jsp.jdbc_project_architecture_with_crud.dao.CustomerDao;
import com.jsp.jdbc_project_architecture_with_crud.dto.Customer;
import com.jsp.jdbc_project_architecture_with_crud.service.CustomerService;

public class CustomerController {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		CustomerService customerService = new CustomerService();
		Customer customer = null;
		while (true) {
			System.out.println("----Please enter your choice----");
			System.out.println("Press ==> 1 to insert");
			System.out.println("Press ==> 2 to update");
			System.out.println("Press ==> 3 to delete by id");
			System.out.println("Press ==> 4 to display");
			System.out.println("Press ==> 5 to displaybyid");
			System.out.println("Press ==> 6 to filter data by address");
			int choice = sc.nextInt();
			switch (choice) {
			case 1: {
				System.out.println("----You have selected insert data");
				System.out.println("Enter id");
				int id = sc.nextInt();
				System.out.println("Enter name");
				String name = sc.next();
				name += sc.nextLine();
				System.out.println("Enter email");
				String email = sc.nextLine();
				System.out.println("Enter address");
				String address = sc.nextLine();
				System.out.println("Enter phone");
				long phone = sc.nextLong();
				customer = new Customer(id, name, phone, email, address);
				customerService.saveCustomerService(customer);
				break;
			}
			case 2: {
				System.out.println("----You have selected update data----");
				System.out.println("Press ==> 1 to update name");
				System.out.println("Press ==> 2 to update email");
				System.out.println("Press ==> 3 to update phone");
				System.out.println("Press ==> 4 to update address");
				int choicee = sc.nextInt();
				switch (choicee) {
				case 1: {
					System.out.println("----You have selected update name----");
					System.out.println("Enter id");
					int id = sc.nextInt();
					System.out.println("Enter name");
					String name = sc.next();
					int a = customerService.updateCustomerService(id, name);
					if (a != 0) {
						System.out.println("Data Updated Successfully!!!");
					} else {
						System.err.println("Data Not Updated!!!");
					}
					break;
				}
				case 2: {
					System.out.println("----You have selected update email----");
					System.out.println("Enter id");
					int id = sc.nextInt();
					System.out.println("Enter email");
					String email = sc.next();
					int a = customerService.updateCustomerService(email, id);
					if (a != 0) {
						System.out.println("Data Updated Successfully!!!");
					} else {
						System.err.println("Data Not Updated!!!");
					}
					break;
				}
				case 3: {
					System.out.println("----You have selected update phone----");
					System.out.println("Enter id");
					int id = sc.nextInt();
					System.out.println("Enter phone");
					long phone = sc.nextLong();
					int a = customerService.updatePhoneService(id, phone);
					if (a != 0) {
						System.out.println("Data Updated Successfully!!!");
					} else {
						System.err.println("Data Not Updated!!!");
					}
					break;
				}
				case 4: {
					System.out.println("----You have selected update address----");
					System.out.println("Enter id");
					int id = sc.nextInt();
					System.out.println("Enter name");
					String address = sc.next();
					int a = customerService.updateAddressService(id, address);
					if (a != 0) {
						System.out.println("Data Updated Successfully!!!");
					} else {
						System.err.println("Data Not Updated!!!");
					}
				}
				}
				break;
			}
			case 3: {
				System.out.println("You have selected delete data");
				System.out.println("Enter id");
				int id = sc.nextInt();
				int a = customerService.getDeleteByIdService(id);
				if (a != 0) {
					System.out.println("Data deleted successfully!!!!!");
				} else {
					System.err.println("Please check id");
				}
				break;
			}
			case 4: {
				System.out.println("----You have selected Display Data----");
				List<Customer> customers = customerService.getAllCustomerService();
				if (!customers.isEmpty()) {
					for (Customer customer2 : customers) {
						System.out.println(customer2);
					}
				} else {
					System.out.println();
				}
				break;
			}
			case 5: {
				System.out.println("You have selected Display Data By ID");
				System.out.println("Enter id");
				int id = sc.nextInt();
				List<Customer> customers = customerService.displayCustomerByIDService(id);
				if (!customers.isEmpty()) {
					for (Customer customer2 : customers) {
						System.out.println(customer2);
					}
				} else {
					System.out.println("Please check ID");
				}

				break;

			}
			case 6: {
				System.out.println("Enter address");
				String address = sc.next();
				address += sc.nextLine();
				List<Customer> filter = customerService.filterCustomerByAdress(address);
				if (!filter.isEmpty()) {
					for (Customer customer2 : filter) {
						System.out.println(customer2);
					}
				} else
					System.err.println("Address Not Available");
			}
				break;
			}
		}
	}

}
