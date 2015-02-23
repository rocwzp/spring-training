/**
 * 
 */
package com.sivalabs.springdemo;

import java.util.List;

/**
 * @author skatam
 *
 */
public class UserService {
	private UserDAO userDAO;
	public List<User> getUsers() {
		return userDAO.getUsers();
	}
	
	public UserService(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
}
