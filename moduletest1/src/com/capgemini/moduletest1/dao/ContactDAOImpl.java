package com.capgemini.moduletest1.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.capgemini.moduletest1.bean.ContactBean;

public class ContactDAOImpl implements ContactDAO{
	
	FileReader reader;
	Properties prop;
	ContactBean contact;

	public ContactDAOImpl()
	{
		try {

			reader = new FileReader("db.properties");
			prop = new Properties();
			prop.load(reader);
			Class.forName(prop.getProperty("driverClass"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	@Override
	public List<ContactBean> showAllContacts() {
			List<ContactBean> list = new ArrayList<ContactBean>();
			try(Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"),
					prop.getProperty("dbUser"),prop.getProperty("dbPassword"));
					Statement stmt = conn.createStatement();
					ResultSet rs = stmt.executeQuery(prop.getProperty("query1"))
					){
				while(rs.next()) {
					contact = new ContactBean();
					contact.setName(rs.getString(1));
					contact.setNumber(rs.getInt(2));
					contact.setGroup(rs.getString(3));
					list.add(contact);

				}
				return list;

			}catch(Exception e) {
				e.printStackTrace();
			}
		return null;
	}

	@Override
	public boolean searchForContact() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addContact(ContactBean bean) {
		try(Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"),
				prop.getProperty("dbUser"),prop.getProperty("dbPassword"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("insertQuery"))
		){
			pstmt.setString(1,contact.getName());
			pstmt.setInt(2, contact.getNumber());
			pstmt.setString(3, contact.getGroup());
			
			int count = pstmt.executeUpdate();
			
			if(count > 0)
			{
				return true;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}


	@Override
	public boolean deleteContact(String name) {
		try(Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"),
				prop.getProperty("dbUser"),prop.getProperty("dbPassword"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("deleteQuery"))
		){
			pstmt.setString(1, name);
			
			int count = pstmt.executeUpdate();
			
			if(count > 0)
			{
				return true;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}


	@Override
	public boolean editContact(String name, int number, String group) {
		try(Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"),
				prop.getProperty("dbUser"),prop.getProperty("dbPassword"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("updateQuery"))
		){
			pstmt.setString(1, name);
			pstmt.setInt(2, number);
			pstmt.setString(3, group);
			
			int count = pstmt.executeUpdate();
			
			if(count > 0)
			{
				return true;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
}
