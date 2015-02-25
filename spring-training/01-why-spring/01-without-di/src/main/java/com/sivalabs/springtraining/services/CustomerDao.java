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
public interface CustomerDao {
	public List<Customer> getCustomerData();
}
