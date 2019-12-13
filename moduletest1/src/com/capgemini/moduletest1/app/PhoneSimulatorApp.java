package com.capgemini.moduletest1.app;

import java.util.List;
import java.util.Scanner;

import com.capgemini.moduletest1.bean.ContactBean;
import com.capgemini.moduletest1.factory.ContactFactory;
import com.capgemini.moduletest1.services.ContactServices;

public class PhoneSimulatorApp {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		while(true) {

			System.out.println("Welcome to Phone Simulator Application Development");
			System.out.println("--------------------------------------------------");
			System.out.println("Press 1 to Show All Contacts");
			System.out.println("Press 2 to Search for Contact");
			System.out.println("Press 3 to Operate on Contact(add,delete,contact)");
			int choice = sc.nextInt();

			switch(choice) {
			case 1:System.out.println("List of contacts");
			ContactServices services = ContactFactory.instanceOfContactServices();

			List<ContactBean> list = services.showAllContacts();
			
			if(list != null) {
				for (ContactBean user : list) {
					System.out.println(user);
				}
			}

			break;
			case 2:System.out.println("Press 1 to Call");
			System.out.println("Press 2 to Message");
			System.out.println("Press 3 to go back to main menu");

			int ch1 = sc.nextInt();
			switch(ch1) {
			case 1:System.out.println("Calling you");
				break;
			case 2:System.out.println("Messaging you");
				break;
			case 3:System.out.println("Back to main menu");
				break;

			}
			break;
			case 3:System.out.println("Press 1 to add contact");
			System.out.println("Press 2 to delte contact");
			System.out.println("Press 3 to edit contact");
			int ch2 = sc.nextInt();
			switch(ch2) {
			case 1:	ContactServices services1 = ContactFactory.instanceOfContactServices();
			ContactBean cuser = new ContactBean();
			Scanner sc1 = new Scanner(System.in);
			System.out.println("Enter name");
			cuser.setName(sc1.nextLine());
			System.out.println("Enter number");
			cuser.setNumber(Integer.parseInt(sc1.nextLine()));
			System.out.println("Enter group");
			cuser.setGroup(sc1.nextLine());
			break;

			case 2:
				ContactServices services2 = ContactFactory.instanceOfContactServices();
				ContactBean cuser1 = new ContactBean();
				Scanner sc2 = new Scanner(System.in);
				System.out.println("Enter name--");
				cuser1.setName(sc2.nextLine());
				System.out.println("Contact deteled");

				break;
			case 3:
				ContactServices services3 = ContactFactory.instanceOfContactServices();
				ContactBean cuser2 = new ContactBean();

				Scanner sc3 = new Scanner(System.in);

				System.out.println("Enter name.....");
				cuser2.setName(sc3.nextLine());
				System.out.println("Enter number");
				cuser2.setNumber(Integer.parseInt(sc3.nextLine()));
				System.out.println("Enter group");
				cuser2.setGroup(sc3.nextLine());

				break;

			}

			}
		}

	}

}
