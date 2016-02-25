package org.javabrain.faisal.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.javabrains.faisal.dto.UserDetails;
import org.javabrains.faisal.dto.Vehicle;

public class HibernateTest {

	public static void main(String[] args) {
		UserDetails user = new UserDetails();
		UserDetails user2 = new UserDetails();
		user.setUserName("Faisal");
		user2.setUserName("Raza");
		
		
		
		Vehicle vehicle=new Vehicle();
		Vehicle vehicle2=new Vehicle();
		Vehicle vehicle3=new Vehicle();
		
		vehicle.setVehicleName("Bullet ThunderBird");
		vehicle2.setVehicleName("yamaha");
		vehicle3.setVehicleName("bullet");
		
		
		//Didirectional relationship
		user.getVehicle().add(vehicle);
		vehicle.getUserList().add(user);
		
		user.getVehicle().add(vehicle2);
		vehicle2.getUserList().add(user);
		
		user2.getVehicle().add(vehicle3);
		vehicle3.getUserList().add(user2);
		
		// sessionFactory one object per application
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();

		session.beginTransaction(); 
		session.save(user);
		session.save(user2);
		
		session.save(vehicle);
		session.save(vehicle2);
		session.save(vehicle3);
		session.getTransaction().commit();
		session.close();

				
		
	}

}
