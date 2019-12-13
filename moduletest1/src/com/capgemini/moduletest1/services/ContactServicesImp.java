package com.capgemini.moduletest1.services;

import java.util.List;

import com.capgemini.moduletest1.bean.ContactBean;

public class ContactServicesImp implements ContactServices{

	@Override
	public List<ContactBean> showAllContacts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean searchForContact() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addContact(ContactBean bean) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteContact(String name) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean editContact(String name, int number, String group) {
		// TODO Auto-generated method stub
		return false;
	}

}
