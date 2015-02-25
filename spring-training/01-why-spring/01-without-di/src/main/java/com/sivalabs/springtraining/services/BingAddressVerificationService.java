/**
 * 
 */
package com.sivalabs.springtraining.services;

import com.sivalabs.springtraining.domain.Address;

/**
 * @author Siva
 *
 */
public class BingAddressVerificationService 
{

	public void verify(Address address) {
		System.err.println("****** verifying address using BingAddressVerificationService ***************");
		address.setLongitude("820.50");
		address.setLatitude("-625.60");
	}

}
