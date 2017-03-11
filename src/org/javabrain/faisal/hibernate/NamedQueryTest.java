package org.javabrain.faisal.hibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.javabrains.faisal.dto.UserDetails;

public class NamedQueryTest {

	public static void main(String[] args) {
		
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		
		Session session=sessionFactory.openSession();
		
		Query query=session.getNamedQuery("UserDetails.byId");
		query.setInteger("userId", 2);
		List<UserDetails> users=query.list();
		
		for(UserDetails u:users)
			System.out.println(u.getUserId()+" "+u.getUserName());
		

		query=session.getNamedQuery("UserDetails.byName");
		query.setString("userName", "user 2");
		users=query.list();
		
		for(UserDetails u:users)
			System.out.println(u.getUserId()+" "+u.getUserName());
		
	}

}
