/**
 * 
 */
package com.sivalabs.springtraining;

import java.util.List;


/**
 * @author Siva
 *
 */
public class UserService 
{
	
	private UserDao userDao;
	
	public UserService() {
		System.out.println("---------UserService---------------");
	}
	public UserService(UserDao userDao) {
		System.out.println("---------UserService(UserDao)---------------");
		this.userDao = userDao;
	}
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public List<User> findAll() {
		return userDao.findAll();
	}

	public User create(User user) {
		return userDao.create(user);
	}

	public User findUserById(int id) {
		return userDao.findUserById(id);
	}
	
}

