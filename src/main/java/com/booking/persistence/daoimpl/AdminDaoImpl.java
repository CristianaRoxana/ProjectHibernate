package com.booking.persistence.daoimpl;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.booking.persistence.model.Admin;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class AdminDaoImpl {
	private static final Log logger = LogFactory.getLog(AdminDaoImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	
	public void addAdmin(Admin admin) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(admin);
		logger.info("Admin saved successfully, Admin Details="+admin);
	}

	
	public void updateAdmin(Admin admin) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(admin);
		logger.info(" Admin  updated successfully,  Admin  Details="+admin);
	}

	@SuppressWarnings("unchecked")
	
	public  List<Admin> listAdmins() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Admin> adminiList = session.createQuery("from admin").list();
		for(Admin admin : adminiList){
			logger.info(" Admin  List::"+admin);
		}
		return adminiList;
	}

	
	public Admin getAdminById(int adminID) {
		Session session = this.sessionFactory.getCurrentSession();		
		Admin admin = (Admin) session.load(Admin.class, new Integer(adminID));
		logger.info(" Admin  loaded successfully, Admin  details="+admin);
		return admin;
	}

	
	public void removeAdmin(int adminID) {
		Session session = this.sessionFactory.getCurrentSession();
		Admin admin = (Admin) session.load(Admin.class, new Integer(adminID));
		if(null != admin){
			session.delete(admin);
		}
		logger.info("Admin deleted successfully, admin details="+admin);
	}


}
