/**
 * 
 */
package com.sivalabs.springtraining.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sivalabs.springtraining.entities.User;


/**
 * @author user
 *
 */
@Service
@Transactional
public class UserService {

	@PersistenceContext
	EntityManager entityManager;
	
	public User create(User user) {
		entityManager.persist(user);
		return user;
	}
	
	public void save(List<User> users) {
		for (User user : users) {
			create(user);
		}
	}
	
	@Transactional(readOnly=true)
	public List<User> findAll() {
		TypedQuery<User> query = entityManager.createQuery("select u from User u", User.class);
		List<User> resultList = query.getResultList();
		return resultList;
	}
	
	@Transactional(readOnly=true)
	public User findById(Integer userId) {
		TypedQuery<User> query = entityManager.createQuery("select u from User u where u.id=?1", User.class);
		query.setParameter(1, userId);
		User user = null;
		try {
			user = query.getSingleResult();
		} catch (NoResultException | NonUniqueResultException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	public void update(User user) {
		entityManager.merge(user);
	}
	
	public void delete(Integer userId) {
		User user = entityManager.find(User.class, userId);
		entityManager.remove(user);
	}

	public User login(String email, String password) {
		return null;
	}
}
