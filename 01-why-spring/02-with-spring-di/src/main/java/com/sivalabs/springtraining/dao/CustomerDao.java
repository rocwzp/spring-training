/**
 * 
 */
package com.sivalabs.springtraining.dao;

import java.util.List;

import com.sivalabs.springtraining.domain.Customer;

/**
 * @author Siva
 *
 */
public interface CustomerDao {
	public List<Customer> getCustomerData();
}
