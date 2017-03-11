package org.javabrain.faisal.hibernate;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.javabrains.faisal.dto.UserDetails;

public class HQLTest {

	public static void main(String[] args) {
		System.out.println("HQL Test:");
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		
		Session session=sessionFactory.openSession();
		//session.beginTransaction();
		String minId="5";
		String userName="user 9";
		Query query=session.createQuery("from UserDetails where userId>:userId and userName=:userName");
		query.setInteger("userId", Integer.parseInt(minId));
		query.setString("userName", userName);
		
		//pagination..!
//		query.setFirstResult(5);
//		query.setMaxResults(4);
//		
		List<UserDetails> users=(List<UserDetails>) query.list();
		
		//session.getTransaction().commit();
		session.close();
		
		
		for(UserDetails user:users){
			System.out.println(user.getUserName());
			
		}
			
		
		
		System.out.println("size of the list is: "+users.size());
		
		
		
	}

}
