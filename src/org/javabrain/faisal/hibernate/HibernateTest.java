package org.javabrain.faisal.hibernate;

import java.util.List;
import java.util.function.ObjLongConsumer;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.javabrains.faisal.dto.Address;
import org.javabrains.faisal.dto.UserDetails;
public class HibernateTest {

	public static void main(String[] args) {
		
		
	
		// sessionFactory one object per application
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		UserDetails user=new UserDetails();
		user.setUserName("faisal");	
		Address homeAddress=new Address();
		homeAddress.setCity("Gopalganj");
		homeAddress.setPincode("841428");
		homeAddress.setState("Bihar");
		homeAddress.setStreet("Dargah Road");
		user.setHomeAddress(homeAddress);
		user.setOfficeAddress(homeAddress);
		session.save(user);
		session.getTransaction().commit();		
		
		user=null;
		session=sessionFactory.openSession();
		session.beginTransaction();
		user=(UserDetails)session.get(UserDetails.class, 1);
		System.out.println(user);
		
		
		
	}

}
