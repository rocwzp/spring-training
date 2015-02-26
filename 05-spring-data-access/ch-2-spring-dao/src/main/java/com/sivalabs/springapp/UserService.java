/**
 * 
 */
package com.sivalabs.springapp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


/**
 * @author Siva
 *
 */
@Service
public class UserService 
{
	//@Autowired
	private UserDao userDao;
	
	@Autowired
	public UserService(@Qualifier("JdbcUserDao") UserDao userDao) {
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

