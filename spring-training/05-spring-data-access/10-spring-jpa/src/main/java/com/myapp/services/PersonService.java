/**
 * 
 */
package com.myapp.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myapp.entities.Person;
import com.myapp.repositories.PersonRepository;


/**
 * @author user
 *
 */
@Service
@Transactional
public class PersonService {

	@Autowired
	private PersonRepository personRepository;
	
	@PersistenceContext
	EntityManager em;
	
	public Person login(String email, String password) {
		/*
		TypedQuery<Person> query = em.createQuery("select p from Person p where p.email=?1 and p.password=?2",	 Person.class);
		query.setParameter(1, email);
		query.setParameter(2, password);
		List<Person> resultList = query.getResultList();
		if(!resultList.isEmpty()){
			return resultList.get(0);
		}
		return null;
		*/
		return personRepository.login(email, password);
	}
	
	public Person create(Person person) {
		personRepository.save(person);
		return person;
	}
	
	public void save(List<Person> persons) {
		personRepository.save(persons);
	}
	
	@Transactional(readOnly=true)
	public List<Person> findAll() {
		return personRepository.findAll();
	}
	
	@Transactional(readOnly=true)
	public Person findById(Integer personId) {
		return personRepository.findOne(personId);
	}
	
	public void update(Person person) {
		personRepository.save(person);
	}
	
	public void delete(Integer personId) {
		personRepository.delete(personId);
	}
}
