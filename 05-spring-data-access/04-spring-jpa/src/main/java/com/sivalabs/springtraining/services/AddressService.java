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

import com.sivalabs.springtraining.entities.Address;


/**
 * @author user
 *
 */
@Service
@Transactional
public class AddressService {

	@PersistenceContext
	EntityManager entityManager;
	
	public Address create(Address address) {
		entityManager.persist(address);
		return address;
	}
	
	public void save(List<Address> addresss) {
		for (Address address : addresss) {
			create(address);
		}
	}
	
	@Transactional(readOnly=true)
	public List<Address> findAll() {
		TypedQuery<Address> query = entityManager.createQuery("select a from Address a", Address.class);
		List<Address> resultList = query.getResultList();
		return resultList;
	}
	
	@Transactional(readOnly=true)
	public Address findById(Integer addressId) {
		TypedQuery<Address> query = entityManager.createQuery("select a from Address a where a.id=?1", Address.class);
		query.setParameter(1, addressId);
		Address address = null;
		try {
			address = query.getSingleResult();
		} catch (NoResultException | NonUniqueResultException e) {
			e.printStackTrace();
		}
		return address;
	}
	
	public void update(Address address) {
		entityManager.merge(address);
	}
	
	public void delete(Integer addressId) {
		Address address = entityManager.find(Address.class, addressId);
		entityManager.remove(address);
	}
}
