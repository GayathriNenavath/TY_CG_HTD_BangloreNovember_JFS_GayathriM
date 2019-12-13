package com.capgemini.moduletest1.dao;

import java.util.List;

import com.capgemini.moduletest1.bean.ContactBean;

public interface ContactDAO {
	public List<ContactBean> showAllContacts();
	public boolean searchForContact();
	public boolean addContact(ContactBean bean);
	public boolean deleteContact(String name);
	public boolean editContact(String name,int number,String group);
}
