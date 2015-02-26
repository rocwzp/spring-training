/**
 * 
 */
package com.sivalabs.springtraining.services.impl;

import com.sivalabs.springtraining.domain.Address;
import com.sivalabs.springtraining.services.AddressVerificationService;

/**
 * @author Siva
 *
 */
public class BingAddressVerificationService implements AddressVerificationService 
{	
	@Override
	public void verify(Address address) {
		System.err.println("****** verifying address using BingAddressVerificationService ***************");
		address.setLongitude("820.50");
		address.setLatitude("-625.60");
	}

}
