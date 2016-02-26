package org.javabrain.faisal.hibernate;
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
		UserDetails user=(UserDetails)session.get(UserDetails.class, 6);
		session.getTransaction().commit();
		session.close();

		
		session = sessionFactory.openSession();
		session.beginTransaction(); 		
		session.update(user);
		session.getTransaction().commit();
		session.close();

				
		
	}

}
