package com.jsp.jdbc_project_architecture_with_prepared_statement.controller;

import java.util.List;
import java.util.Scanner;

import com.jsp.jdbc_project_architecture_with_prepared_statement.dto.Phone;
import com.jsp.jdbc_project_architecture_with_prepared_statement.service.PhoneService;

public class PhoneController {
	
	public static void main(String[] args) {
		PhoneService phoneService = new PhoneService();
		Phone phone = null;
		Scanner scn = new Scanner(System.in);
	
		System.out.println("Press 1 ==> to Insert");
		System.out.println("Press 2 ==> to Display");
		int choice=scn.nextInt();
		switch(choice)
		{
		case 1 : {
			System.out.println("Enter id");
			int id=scn.nextInt();
			System.out.println("Enter name");
			String name=scn.next();
//			name+=scn.nextLine();
			System.out.println("Enter color");
			String color=scn.next();
			System.out.println("Enter Ram");
			String ram=scn.next();
			System.out.println("Enter IMEINO");
			long imeino=scn.nextLong();
			System.out.println("Enter Camera");
			String camera=scn.next();
			phone=new Phone(id, name, imeino, ram, camera, color);
			phoneService.getPhoneService(phone);
			break;
		}
		case 2 : {
			List<Phone> phones = phoneService.getAllPhoneDao();
			if(!phones.isEmpty())
			{
			for (Phone phone2 : phones) {
				System.out.println(phone2);
			}
			}
			break;
		}
		}
	}

}
