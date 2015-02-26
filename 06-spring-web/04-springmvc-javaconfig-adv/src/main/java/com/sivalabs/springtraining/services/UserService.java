/**
 * 
 */
package com.sivalabs.springtraining.services;

import java.util.List;

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

	private UserRepository userRepository;
	
	@Autowired
	public UserService(UserRepository repo){
		this.userRepository = repo;
	}
	
	public List<User> findAllUsers() {
		return userRepository.findAll();
	}

	public User findUserById(int id) {
		return userRepository.findOne(id);
	}

	public User createUser(User user) {
		return userRepository.save(user);
	}

	public User updateUser(User user) {
		return userRepository.save(user);
	}

	public void deleteUser(int id) {
		userRepository.delete(id);
	}

}
