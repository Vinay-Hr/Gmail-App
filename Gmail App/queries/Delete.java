package com.te.gmailApp.queries;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Delete {
	
	public static void delete() {
		
			EntityManagerFactory factory = null;
			EntityManager manager = null;
			EntityTransaction transaction = null;
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter the Gmail Account id you want to Delete :");
			int id=sc.nextInt(); 
					
			try {
				factory = Persistence.createEntityManagerFactory("gmailLogin");
				manager = factory.createEntityManager();
				transaction = manager.getTransaction();
				transaction.begin();
				
				String  updateData="Delete from Account where id=:id";
				Query query=manager.createQuery(updateData);
				
				query.setParameter("id", id);
				transaction.commit();
				
		
				
				System.out.println("Account successfully deleted !!");
			} catch (Exception e) {
				if (transaction != null) {
					transaction.rollback();
				}
				e.printStackTrace();
			} finally {
				if (manager != null) {
					manager.close();
				}
				if (factory != null) {
					factory.close();
				}
			}

}
}