/**
 * 
 */
package com.sivalabs.springtraining;

import org.springframework.stereotype.Component;

/**
 * @author user
 *
 */
@Component
public class UserService {

	public String login(String user, String pwd) {
		System.out.println("-------------login-----------");
		return "admin".equals(user) ? "success":"failure";
	}
	
	public void save(String user) {
		System.out.println("Saving user "+user);
	}
}

