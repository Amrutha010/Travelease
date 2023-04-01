package com.travelease.service;

import java.util.List;

import com.travelease.exception.CustomerException;
import com.travelease.models.Customer;

public interface CustomerServices {
	
	public Customer addCustomer(Customer customer) throws CustomerException;
	
	public Customer updateCustomer(Customer customer) throws CustomerException;
	
	public Customer deleteCustomer(Integer customerId) throws CustomerException;
	
	public Customer viewCustomer(Integer customerId) throws CustomerException;
	
	public List<Customer> viewAllCustomer() throws CustomerException;
	
}
