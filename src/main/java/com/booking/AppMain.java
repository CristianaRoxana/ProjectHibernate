package com.booking;

import java.util.HashSet;
import java.util.Set;
import org.hibernate.Session;
import com.booking.persistence.model.Admin;
import com.booking.persistence.model.Agent;
import com.booking.persistence.model.Customer;
import com.booking.persistence.model.Reservation;
import com.booking.persistence.util.HibernateUtil;


public class AppMain {
	public static void main(String[] args) {

		System.out.println("Hibernate one to many, many to many ");
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		Agent agent = new Agent();
		agent.setNameAgent("agent");
		agent.setDetailsAgent("agentDetails");
		agent.setIdAdmin(1);
		session.save(agent);

		Admin admin = new Admin();
		admin.setEmailAdmin("admin@yahoo.com");
		admin.setPasswordAdmin("pass");
		agent.getAdmins().add(admin);
		session.save(admin);
		
		
		
		Customer customer = new Customer();
		customer.setCustomerEmail("customeremail@yahoo.com");
		customer.setCustomerFirstName("customerFirstName");
		customer.setCustomerLastName("customerLastName");
		customer.setCustomerPhone("09281983");
		
		Reservation reserv1 = new Reservation(10, "10/12/2010", "10/01/2011", "Budapesta", "primatarezervare");
		Reservation reserv2 = new Reservation(12, "11/12/2010", "11/01/2011", "Romania", "douatarezervare");
		Set<Reservation> reservations = new HashSet<Reservation>();
		reservations.add(reserv1);
		reservations.add(reserv2);

		customer.setReservations(reservations);

		session.save(customer);
		session.getTransaction().commit();

		System.out.println("Done");
		
	}
}
