package com.te.gmailApp.queries;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Update {
	public static void name() {
		for(; ;) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your choice :");
		System.out.println("1.name\n 2.email\n 3.password\n 4.back");
		int a = sc.nextInt();
		switch (a) {
		case 1:
			EntityManagerFactory factory = null;
			EntityManager manager = null;
			EntityTransaction transaction = null;

			System.out.println("Enter the user id you want to update :");
			int id = sc.nextInt();
			System.out.println("Enter the username you want to update :");
			String name = sc.next();

			factory = Persistence.createEntityManagerFactory("gmailLogin");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();

			String updateData = "update Account set name= :name where id=:id";
			Query query = manager.createQuery(updateData);

			query.setParameter("id", id);
			query.setParameter("name", name);
			int result=query.executeUpdate();
			transaction.commit();
			if(result==0) {
			System.out.println("name has been successfully updated");
			}
			break;
		case 2:
			System.out.println("Enter the user id u wanna update");
			int id1 = sc.nextInt();
			System.out.println("Enter the Email u wish to update");
			String email = sc.next();

			factory = Persistence.createEntityManagerFactory("gmailLogin");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			if(email.equals(email)) {
			String updateData1 = "update Account set Email= :Email where Email=:Email";
			Query query1 = manager.createQuery(updateData1);

			query1.setParameter("Email", id1);
			query1.setParameter("Email", email);
			int result2=query1.executeUpdate();
			transaction.commit();
			if(result2==0) {
			
			System.out.println("Email has been successfully updated");
			}
			}
				break;
			
		case 3:
			System.out.println("Enter the user id you want update :");
			int id2 = sc.nextInt();
			System.out.println("Enter the password you want to update :");
			String password = sc.next();

			factory = Persistence.createEntityManagerFactory("gmailLogin");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();

			String updateData2 = "update Account set password= :password where id=:id";
			Query query2 = manager.createQuery(updateData2);

			query2.setParameter("id", id2);
			query2.setParameter("password", password);
			int result3=query2.executeUpdate();
			transaction.commit();
			if(result3==0) {
			
			System.out.println("password has been successfully updated");
			}
			break;
		default:
			LoginRegister.compose();

		}

	}
}
}