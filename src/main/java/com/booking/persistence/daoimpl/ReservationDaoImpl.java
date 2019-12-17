package com.booking.persistence.daoimpl;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.booking.persistence.model.Admin;
import com.booking.persistence.model.Reservation;

public class ReservationDaoImpl {
	private static final Log logger = LogFactory.getLog(ReservationDaoImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	
	public void addReservation(Reservation reservation) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(reservation);
		logger.info("Reservation saved successfully,Reservation Details="+reservation);
	}

	
	public void updateReservation(Reservation reservation) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(reservation);
		logger.info(" Reservation updated successfully,  Reservation  Details="+reservation);
	}

	@SuppressWarnings("unchecked")
	
	public  List<Reservation> listReservations() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Reservation> reservationsList = session.createQuery("from reservation").list();
		for(Reservation reservation : reservationsList){
			logger.info("Reservation  List::"+reservation);
		}
		return reservationsList;
	}

	
	public Reservation getReservationById(int reservationID) {
		Session session = this.sessionFactory.getCurrentSession();		
		Reservation reservation = (Reservation) session.load(Reservation.class, new Integer(reservationID));
		logger.info(" Reservation  loaded successfully,Reservation  details="+reservation);
		return reservation;
	}

	
	public void removeReservation(int reservationID) {
		Session session = this.sessionFactory.getCurrentSession();
		Reservation  reservation = (Reservation) session.load(Admin.class, new Integer(reservationID));
		if(null != reservation){
			session.delete(reservation);
		}
		logger.info("Admin deleted successfully, admin details="+reservation);
	}
}
