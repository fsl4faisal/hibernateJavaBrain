package org.javabrain.faisal.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.javabrains.faisal.dto.Address;
import org.javabrains.faisal.dto.FourWheeler;
import org.javabrains.faisal.dto.TwoWheeler;
import org.javabrains.faisal.dto.UserDetails;
import org.javabrains.faisal.dto.Vehicle;

public class HibernateTest {

	public static void main(String[] args) {

		// sessionFactory one object per application
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		UserDetails user = new UserDetails();
		user.setUserName("faisal");

		UserDetails user2 = new UserDetails();

		user2.setUserName("Arham");

		Vehicle vehicle1 = new Vehicle();
		vehicle1.setVehicleName("generic vehicle 1");

		Vehicle vehicle2 = new Vehicle();
		vehicle2.setVehicleName("generic vehicle 2");

		vehicle1.getUserList().add(user);
		user.getVehicle().add(vehicle1);

		vehicle2.getUserList().add(user2);
		user2.getVehicle().add(vehicle2);

		FourWheeler car = new FourWheeler();
		car.setVehicleName("Porche");
		car.setSteeringWheel("awesome steering wheel");

		TwoWheeler bike = new TwoWheeler();
		bike.setVehicleName("Thunderbird");
		bike.setSteeringHandle("Awesome awesome steering handle");

		user.getVehicle().add(car);
		car.getUserList().add(user);

		user.getVehicle().add(bike);
		bike.getUserList().add(user);

		user2.getVehicle().add(bike);
		bike.getUserList().add(user2);
		
		Address homeAddress = new Address();
		homeAddress.setCity("Gopalganj");
		homeAddress.setPincode("841428");
		homeAddress.setState("Bihar");
		homeAddress.setStreet("Dargah Road");

		Address officeAddress = new Address();
		officeAddress.setCity("Gopalganj 2");
		officeAddress.setPincode("841428 22");
		officeAddress.setState("Bihar 2");
		officeAddress.setStreet("Dargah Road 2");

		user.getAddress().add(homeAddress);
		user.getAddress().add(officeAddress);

		session.beginTransaction();
		session.save(user2);
		session.save(user);
		session.save(new UserDetails("Rabbani"));
		session.save(new UserDetails("Usmani"));
		session.save(new UserDetails("Saquib"));
		session.save(new UserDetails("Atif"));
		session.getTransaction().commit();

		user = null;
		session = sessionFactory.openSession();
		session.beginTransaction();
		user = (UserDetails) session.get(UserDetails.class, 1);
		System.out.println(user);
		session.close();
		System.out.println(user.getAddress().size());

	}

}
