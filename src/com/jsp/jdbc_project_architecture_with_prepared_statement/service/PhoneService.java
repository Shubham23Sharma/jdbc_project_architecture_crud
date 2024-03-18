package com.jsp.jdbc_project_architecture_with_prepared_statement.service;

import java.util.List;

import com.jsp.jdbc_project_architecture_with_prepared_statement.dao.PhoneDao;
import com.jsp.jdbc_project_architecture_with_prepared_statement.dto.Phone;

public class PhoneService {
	
	PhoneDao phoneDao = new PhoneDao();
	
	public  Phone getPhoneService(Phone phone)
	{
			System.out.println("!!!Data inserted!!!");
			return phoneDao.savePhoneDao(phone);
			
	}
	
	public List<Phone> getAllPhoneDao()
	{
		return phoneDao.getAllPhoneDao();
	}

}
