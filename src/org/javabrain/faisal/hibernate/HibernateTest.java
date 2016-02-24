package org.javabrain.faisal.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.javabrains.faisal.dto.Address;
import org.javabrains.faisal.dto.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
		UserDetails user = new UserDetails();
		UserDetails user2 = new UserDetails();
		user.setUserName("Faisal");
		
		Address address=new Address();
		address.setCity("Delhi");
		address.setPincode("110025");
		address.setState("Delhi");
		address.setStreet("Shaheen bagh");
		
		user.setAddress(address);
		
		user2.setUserName("Raza");
		user2.setAddress(address);

		// sessionFactory one object per application
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();

		session.beginTransaction();
		session.save(user);
		session.save(user2);
		session.getTransaction().commit();
		session.close();

		user = null;

		session = sessionFactory.openSession();
		session.beginTransaction();
		user=(UserDetails)session.get(UserDetails.class, 1);

		System.out.println(user.getUserName()+" "+user.getAddress());
	}

}
