/**
 * 
 */
package com.sivalabs.springtraining.services;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sivalabs.springtraining.domain.Customer;
import com.sivalabs.springtraining.services.CustomerLocator;

/**
 * @author Siva
 *
 */
public class CustomerLocatorTest 
{
	private static CustomerLocator locator;
	
	@BeforeClass
	public static void init() {
		locator = new CustomerLocator();
	}
	
	@AfterClass
	public static void destroy() {
		locator = null;
	}
	
	@Test
	public void testGetCustomersWithLocations() {
		List<Customer> customers = locator.getCustomersWithLocations();
		for (Customer customer : customers) {
			System.err.println(customer.getName()+
					" Latitude: "+customer.getAddress().getLatitude()+
					", Longitude: "+customer.getAddress().getLongitude());
		}
	}
}
