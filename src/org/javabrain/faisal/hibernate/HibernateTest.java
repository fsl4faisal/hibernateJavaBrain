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
		
		Address address2=new Address();
		address2.setCity("Gopalganj");
		address2.setPincode("841428");
		address2.setState("Bihar");
		address2.setStreet("Dargah");
		
		user.getListOfAddressses().add(address);
		user.getListOfAddressses().add(address2);
		user2.setUserName("Raza");
		user2.getListOfAddressses().add(address);
		
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
		session.close();
		System.out.println("size"+user.getListOfAddressses().size());
		
	}

}
