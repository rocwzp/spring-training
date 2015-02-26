/**
 * 
 */
package com.sivalabs.springtraining.services;

import org.springframework.stereotype.Service;

/**
 * @author user
 *
 */
@Service
public class EchoService {

	public String echo(String val) {
		return val+"..."+val;
	}
}
