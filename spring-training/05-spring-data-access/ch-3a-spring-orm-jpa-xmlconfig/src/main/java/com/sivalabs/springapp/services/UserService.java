/**
 * 
 */
package com.sivalabs.springapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sivalabs.springapp.dao.UserDao;
import com.sivalabs.springapp.entities.User;


/**
 * @author Siva
 *
 */
@Service
public class UserService 
{
	private UserDao userDao;
	
	@Autowired
	public UserService(UserDao userDao) {
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

