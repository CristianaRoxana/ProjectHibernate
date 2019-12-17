package com.booking.persistence.daoimpl;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.booking.persistence.model.Customer;

public class CustomerDaoImpl {
	private static final Log logger = LogFactory.getLog(CustomerDaoImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	
	public void addCustomer(Customer customer) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(customer);
		logger.info("Customer saved successfully,Customer Details="+customer);
	}

	
	public void updateCustomer(Customer customer) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(customer);
		logger.info(" Customer updated successfully,  Admin  Details="+customer);
	}

	@SuppressWarnings("unchecked")
	
	public  List<Customer> listCustomers() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Customer> customeriList = session.createQuery("from customer").list();
		for(Customer customer : customeriList){
			logger.info("Customer  List::"+customer);
		}
		return customeriList;
	}

	
	public Customer getCustomerById(int customerID) {
		Session session = this.sessionFactory.getCurrentSession();		
		Customer customer = (Customer) session.load(Customer.class, new Integer(customerID));
		logger.info(" Customer  loaded successfully,Customer  details="+customer);
		return customer;
	}

	
	public void removeCustomer(int customerID) {
		Session session = this.sessionFactory.getCurrentSession();
		Customer  customer = (Customer) session.load(Customer.class, new Integer(customerID));
		if(null != customer){
			session.delete(customer);
		}
		logger.info("Customer deleted successfully, customer details="+customer);
	}

}
