package org.javabrain.faisal.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.javabrains.faisal.dto.UserDetails;

public class HibernateTestUpdate {

	public static void main(String[] args) {
		System.out.println("Running HibernateTestUpdate");
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		
		UserDetails user=(UserDetails)session.get(UserDetails.class, 1);
		
		System.out.println(user.getUserId()+" "+user.getUserName());
		user.setUserName(user.getUserName()+" only updated");
		session.update(user);
		session.getTransaction().commit();	
		session.close();
		
		

	}

}
