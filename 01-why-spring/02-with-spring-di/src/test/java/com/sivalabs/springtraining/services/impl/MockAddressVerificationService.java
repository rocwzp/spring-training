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
public class MockAddressVerificationService implements AddressVerificationService {
	
	@Override
	public void verify(Address address) {
		System.err.println("****** verifying address using MockAddressVerificationService ***************");
		address.setLongitude("402.00");
		address.setLatitude("-65.36");
	}

}
