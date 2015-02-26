/**
 * 
 */
package com.sivalabs.springtraining.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sivalabs.springtraining.entities.User;
import com.sivalabs.springtraining.repositories.UserRepository;


/**
 * @author user
 *
 */
@Service
@Transactional
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@PersistenceContext
	EntityManager em;
	
	public User login(String email, String password) {
		return userRepository.login(email, password);
	}
	
	public User create(User user) {
		userRepository.save(user);
		return user;
	}
	
	public void save(List<User> users) {
		userRepository.save(users);
	}
	
	@Transactional(readOnly=true)
	public List<User> findAll() {
		return userRepository.findAll();
	}
	
	@Transactional(readOnly=true)
	public User findById(Integer userId) {
		return userRepository.findOne(userId);
	}
	
	public void update(User user) {
		userRepository.save(user);
	}
	
	public void delete(Integer userId) {
		userRepository.delete(userId);
	}
}
