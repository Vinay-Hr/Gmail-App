package com.te.gmailApp.queries;


import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.te.gmailApp.bean.Account;
import com.te.gmailApp.bean.Inbox;



public class LoginRegister {

	public void login() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to Gmail login Page");
		Account acc1=new Account();
		System.out.println("Enter the Email");
		String email = sc.next();
		System.out.println("Enter the Password");
		String password = sc.next();
		EntityManagerFactory factory = null;
		EntityManager manager = null;
		factory = Persistence.createEntityManagerFactory("gmailLogin");
		manager = factory.createEntityManager();
		String readall = "select Email from Account where email=:email";
		String readall2="select password from Account where password=:password";
		Query query=manager.createQuery(readall);
		Query query2=manager.createQuery(readall2);
		query.setParameter("email", email);
		query2.setParameter("password", password);
		Account account=(Account)query.getSingleResult();
		Account account1=(Account)query2.getSingleResult();
		
		if(email.equals(account) && password.equals(account1))
		{
			System.out.println("Login Successfull");
			System.out.println("1.Inbox\n 2.update\n 3.Deactivate account\n 4.Exit");
			int b = sc.nextInt();
			switch (b) {
			case 1:
				LoginRegister.compose();
				break;
			case 2:
				Update.name();
				break;
			case 3:	System.out.println("Are you sure you want to delete your account ?");
					System.out.println("press \n1.To confirm\n 2.cancel");
					int c=sc.nextInt();
					switch(c) {
					case 1:Delete.delete();
						break;
					case 2:System.out.println("Account Deleted Successfully");
							new MainAccount();
							
					}
					
			default:
				System.out.println("Logout Successfull");
				new Account();

			}

		}else { 
			System.out.println("User does not exist !!");
		}
	}

	

	public void Register() {

		Account acc = new Account();
		EntityManagerFactory factory = null;
		EntityManager manager = null;
		EntityTransaction transaction = null;

		Scanner sc2 = new Scanner(System.in);
		System.out.println("Welcome to Gmail Registration Page :");
		System.out.println("Enter the id");
		int id = sc2.nextInt();
		System.out.println("Enter the user name :");
		String name = sc2.next();
		sc2.nextLine();
		System.out.println("Enter the password :");
		String password = sc2.next();
		sc2.nextLine();
		System.out.println("Enter the Email id :");
		String email = sc2.next();

		acc.setId(id);
		acc.setName(name);
		acc.setPassword(password);
		acc.setEmail(email);

		factory = Persistence.createEntityManagerFactory("gmailLogin");
		manager = factory.createEntityManager();
		transaction = manager.getTransaction();
		transaction.begin();
		manager.persist(acc);
		transaction.commit();
		System.out.println("Registeration successfull");
	}

	public static void compose() {

		Inbox in = new Inbox();
		EntityManagerFactory factory = null;
		EntityManager manager = null;
		EntityTransaction transaction = null;

		Scanner sc = new Scanner(System.in);

		System.out.println("A.Compose a message\n B.Inbox\n C.logout");

		String a = sc.next();
		switch (a) {
		case "A":
			System.out.println("Enter the reciever id");
			int reciverid = sc.nextInt();
			System.out.println("Enter the reciever mail id");
			int userid = sc.nextInt();
			sc.nextLine();
			System.out.println("Enter your message:");
			String msg = sc.next();
			in.setMessage_id(reciverid);
			in.setUser_id(userid);
			in.setMessage(msg);
			factory = Persistence.createEntityManagerFactory("gmailLogin");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(in);
			transaction.commit();
			System.out.println("Message sent successfully !");
			break;
		case "B":

			factory = Persistence.createEntityManagerFactory("gmailLogin");
			manager = factory.createEntityManager();
			String readall = "from  Inbox";
			Query query = manager.createQuery(readall);
			java.util.List<Inbox> l = query.getResultList();
			System.out.println("the sent messages");
			for (Inbox inbox : l) {

				System.out.println(inbox);

			}
			break;
		default:
			System.out.println("logout successfull");
			new MainAccount();
		}

	}


}