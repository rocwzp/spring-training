/**
 * 
 */
package com.sivalabs.springtraining.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.sivalabs.springtraining.entity.Person;

/**
 * @author user
 *
 */
public class PersonService {

	private static final EntityManagerFactory emf = createEMF();

	private static EntityManagerFactory createEMF() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("manager1");
		return entityManagerFactory;
	}
	
	public Person create(Person person) {
		EntityManager entityManager = emf.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			entityManager.persist(person);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
		entityManager.close();
		return person;
	}
	
	public List<Person> findAll() {
		EntityManager entityManager = emf.createEntityManager();
		TypedQuery<Person> query = entityManager.createQuery("select p from Person p", Person.class);
		List<Person> resultList = query.getResultList();
		return resultList;
	}
	
	public Person findById(Integer personId) {
		EntityManager entityManager = emf.createEntityManager();
		TypedQuery<Person> query = entityManager.createQuery("select p from Person p where p.id=?1", Person.class);
		query.setParameter(1, personId);
		Person person = null;
		try {
			person = query.getSingleResult();
		} catch (NoResultException | NonUniqueResultException e) {
			e.printStackTrace();
		}
		//List<Person> resultList = query.getResultList();
		return person;
	}
	
	public void update(Person person) {
		EntityManager entityManager = emf.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			entityManager.merge(person);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
		entityManager.close();
	}
	
	public void delete(Integer personId) {
		EntityManager entityManager = emf.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			/*
			Query query = entityManager.createQuery("delete p from Person p where p.id=?1");
			query.setParameter(1, personId);
			query.executeUpdate();
			*/
			Person person = entityManager.find(Person.class, personId);
			entityManager.remove(person);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
		}
		entityManager.close();
	}

	public void destroy() {
		emf.close();
	}
}
