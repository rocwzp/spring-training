/**
 * 
 */
package com.sivalabs.springtraining;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author user
 *
 */
@Service
public class UserService 
{
	@Autowired
	private UserDao userDao;
	
	/*
	@Autowired
	public UserService(UserDao userDao) {
		this.userDao = userDao;
	}
	 */
	
	/*
	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	*/
	@PostConstruct
	public void initialize() {
		System.out.println("------initalizing userservice-------------");
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("------destroy userservice-------------");
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
