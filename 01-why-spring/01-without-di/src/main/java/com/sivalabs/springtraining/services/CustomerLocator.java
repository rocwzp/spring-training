/**
 * 
 */
package com.sivalabs.springtraining.services;

import java.util.List;

import com.sivalabs.springtraining.domain.Customer;

/**
 * @author Siva
 *
 */
public class CustomerLocator 
{
	private CustomerDao customerDao;
	private BingAddressVerificationService avs;
	
	public CustomerLocator() {
		this.customerDao = new JdbcCustomerDao();
		this.avs = new BingAddressVerificationService();
	}
	
	public List<Customer> getCustomersWithLocations() 
	{
		List<Customer> customers = customerDao.getCustomerData();
		for (Customer customer : customers) {
			avs.verify(customer.getAddress());
		}
		return customers;
		
	}
}
