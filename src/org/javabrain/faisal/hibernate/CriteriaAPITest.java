package org.javabrain.faisal.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.javabrains.faisal.dto.UserDetails;

public class CriteriaAPITest {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();

		Criteria criteria = session.createCriteria(UserDetails.class);
		
		//Both criteria are getting added making it an AND relation and resulting empty result--Look carefully to understand if it's subtle.s
		criteria.add(Restrictions.eq("userName", "user 8"));
		criteria.add(Restrictions.eq("userName", "user 9"));
		List<UserDetails> users = criteria.list();
		
		System.out.println("displaying from the first:");
		for (UserDetails user : users)
			System.out.println(user.getUserId() + " " + user.getUserName());
		
		criteria=session.createCriteria(UserDetails.class);
		criteria.add(Restrictions.or(Restrictions.like("userName", "user 1"), Restrictions.gt("userId", 5)));

		users = criteria.list();
		System.out.println("Displaying again");
		for (UserDetails user : users)
			System.out.println(user.getUserId() + " " + user.getUserName());
	}

}
