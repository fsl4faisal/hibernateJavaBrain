package org.javabrain.faisal.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.javabrains.faisal.dto.UserDetails;

public class CreateSampleUser {

	public static void main(String[] args) {
		System.out.println("creating sample users");
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		
		session.beginTransaction();
		
		for(int i=1;i<10;i++){
			session.save(new UserDetails("user "+i));
		}
		session.getTransaction().commit();
		session.close();
		
	}

}
