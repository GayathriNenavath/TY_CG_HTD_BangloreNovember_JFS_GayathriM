package com.capgemini.moduletest1.factory;

import com.capgemini.moduletest1.dao.ContactDAO;
import com.capgemini.moduletest1.dao.ContactDAOImpl;
import com.capgemini.moduletest1.services.ContactServices;
import com.capgemini.moduletest1.services.ContactServicesImp;

public class ContactFactory {
	private ContactFactory()
	{
		
	}
	

	public static  ContactDAO instanceOfContactDAOImp()
	{
		ContactDAO dao = new ContactDAOImpl();
		return dao;
	}
	public static ContactServices instanceOfContactServices()
	{
		ContactServices services = new ContactServicesImp();
		return services;
	}


}
