/**
 * 
 */
package com.myapp.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myapp.entities.Person;


/**
 * @author user
 *
 */
@Service
@Transactional
public class PersonService {

	@PersistenceContext
	EntityManager entityManager;
	
	public Person create(Person person) {
		entityManager.persist(person);
		return person;
	}
	
	public void save(List<Person> persons) {
		for (Person person : persons) {
			create(person);
		}
	}
	
	@Transactional(readOnly=true)
	public List<Person> findAll() {
		TypedQuery<Person> query = entityManager.createQuery("select p from Person p", Person.class);
		List<Person> resultList = query.getResultList();
		return resultList;
	}
	
	@Transactional(readOnly=true)
	public Person findById(Integer personId) {
		TypedQuery<Person> query = entityManager.createQuery("select p from Person p where p.id=?1", Person.class);
		query.setParameter(1, personId);
		Person person = null;
		try {
			person = query.getSingleResult();
		} catch (NoResultException | NonUniqueResultException e) {
			e.printStackTrace();
		}
		return person;
	}
	
	public void update(Person person) {
		entityManager.merge(person);
	}
	
	public void delete(Integer personId) {
		Person person = entityManager.find(Person.class, personId);
		entityManager.remove(person);
	}
}
