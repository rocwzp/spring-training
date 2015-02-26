/**
 * 
 */
package com.sivalabs.springtraining.services;

import java.util.List;

import com.sivalabs.springtraining.dao.CustomerDao;
import com.sivalabs.springtraining.domain.Customer;

/**
 * @author Siva
 *
 */
public class CustomerLocator {
	private CustomerDao customerDao;
	private AddressVerificationService addressVerificationService;

	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	public void setAddressVerificationService(
			AddressVerificationService addressVerificationService) {
		this.addressVerificationService = addressVerificationService;
	}

	public List<Customer> getCustomersWithLocations() {
		List<Customer> customers = customerDao.getCustomerData();
		for (Customer customer : customers) {
			addressVerificationService.verify(customer.getAddress());
		}
		return customers;

	}
}
