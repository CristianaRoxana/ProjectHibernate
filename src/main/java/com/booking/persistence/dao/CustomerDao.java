package com.booking.persistence.dao;

import java.util.List;
import com.booking.persistence.model.Customer;

public interface CustomerDao {
	public void addCustomer(Customer customer);
	public void updateCustomer(Customer customer);
	public List<Customer> listCustomers();
	public Customer getCustomerById(int customerID);
	public void removeCustomer(int customerID);
}
