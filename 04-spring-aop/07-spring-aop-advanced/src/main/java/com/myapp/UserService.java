/**
 * 
 */
package com.myapp;

import org.springframework.stereotype.Service;

/**
 * @author user
 *
 */
@Service
public class UserService {

	public String login(String user, String pwd) {
		System.out.println("-------------login-----------");
		if(user == null){
			//throw new IllegalArgumentException("Username should not be null");
			throw new NullPointerException("Username should not be null");
		}
		
		if(pwd == null){
			//throw new IllegalArgumentException("Username should not be null");
			throw new IllegalArgumentException("Pwd should not be null");
		}
		return "admin".equals(user) ? "success":"failure";
	}
	
	public void save(String user) {
		System.out.println("Saving user "+user);
	}
}

