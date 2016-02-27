package org.javabrain.faisal.hibernate;

import java.util.List;
import java.util.function.ObjLongConsumer;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.javabrains.faisal.dto.UserDetails;
public class HibernateTest {

	public static void main(String[] args) {
		
		
	
		// sessionFactory one object per application
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		String userId="4";
		String userName="User 3";
		
		//Query query=session.createQuery("select userName from UserDetails where userId = :userId and userName= :userName");
		//query.setFirstResult(2);
		//query.setMaxResults(5);
		//Query query=session.getNamedQuery("UserDetails.byId");
		//query.setParameter("userId", Integer.parseInt(userId));
		
		Query query=session.getNamedQuery("UserDetails.byName");
		query.setParameter("userName", userName);
		
		
		List<UserDetails> users=query.list();
		session.getTransaction().commit();
		session.close();

		//System.out.println("size of list "+users.size()+users.toString());
		
		for(int i=0;i<users.size();i++)
			System.out.println(users.get(i));
		
		//for(UserDetails user:users)
			//System.out.println(user.getUserName());
		
		
	}

}
