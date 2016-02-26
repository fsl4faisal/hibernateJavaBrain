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
		//session.delete(user);
		user.setUserName("updated user");
		session.update(user);
		/*for(int i=0;i<10;i++){
			UserDetails user=new UserDetails();
			user.setUserName("User "+i);
			session.save(user);
		}*/
		session.getTransaction().commit();
		session.close();
		
//		System.out.println(user.getUserId()+" "+user.getUserName());

				
		
	}

}
