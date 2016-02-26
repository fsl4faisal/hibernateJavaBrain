package org.javabrain.faisal.hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.javabrains.faisal.dto.FourWheeler;
import org.javabrains.faisal.dto.TwoWheeler;
import org.javabrains.faisal.dto.Vehicle;
public class HibernateTest {

	public static void main(String[] args) {
		Vehicle vehicle=new Vehicle();
		vehicle.setVehicleName("Car");
		
		TwoWheeler bike=new TwoWheeler();
		bike.setVehicleName("Bike");
		bike.setSteeringHandle("Bike Steering Handle");
		
		FourWheeler car=new FourWheeler();
		car.setVehicleName("Porsche");
		car.setSteeringWheel("Porsche Steering Wheel");
		
		// sessionFactory one object per application
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		Session session = sessionFactory.openSession();

		session.beginTransaction(); 
		
		session.save(vehicle);
		session.save(car);
		session.save(bike);
		
		session.getTransaction().commit();
		session.close();

				
		
	}

}
