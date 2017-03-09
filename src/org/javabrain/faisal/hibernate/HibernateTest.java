package org.javabrain.faisal.hibernate;

import java.util.HashSet;
import java.util.Set;

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
		
		Address officeAddress=new Address();
		officeAddress.setCity("Gopalganj 2");
		officeAddress.setPincode("841428 22");
		officeAddress.setState("Bihar 2");
		officeAddress.setStreet("Dargah Road 2");
		
		user.getAddress().add(homeAddress);
		user.getAddress().add(officeAddress);
		session.save(user);
		session.getTransaction().commit();		
		
		user=null;
		session=sessionFactory.openSession();
		session.beginTransaction();
		user=(UserDetails)session.get(UserDetails.class, 1);
		System.out.println(user);
		
		
		
	}

}
