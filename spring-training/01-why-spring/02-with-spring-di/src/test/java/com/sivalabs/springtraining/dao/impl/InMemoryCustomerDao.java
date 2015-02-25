/**
 * 
 */
package com.sivalabs.springtraining.dao.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.sivalabs.springtraining.dao.CustomerDao;
import com.sivalabs.springtraining.domain.Address;
import com.sivalabs.springtraining.domain.Customer;

/**
 * @author Siva
 *
 */
public class InMemoryCustomerDao implements CustomerDao{

	private static final List<Customer> customers = new ArrayList<>();
	
	public InMemoryCustomerDao() 
	{
		Customer customer1 = new Customer(1, "Siva", new Address("Kukatpally","Hyderabad","AP","500082","India",null,null));
		Customer customer2 = new Customer(2, "Prasad", new Address("Kukatpally","Hyderabad","AP","500082","India",null,null));
		Customer customer3 = new Customer(3, "Reddy", new Address("Kukatpally","Hyderabad","AP","500082","India",null,null));
		
		customers.add(customer1);
		customers.add(customer2);
		customers.add(customer3);
		
	}
	
	@Override
	public List<Customer> getCustomerData() {
		return Collections.unmodifiableList(customers);
	}

}
