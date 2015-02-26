/**
 * 
 */
package com.myapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.myapp.entities.Person;

/**
 * @author user
 *
 */
@Repository
public interface PersonRepository extends JpaRepository<Person, Integer>{

	//public Person findByEmailAndPassword(String email, String password);
	
	@Query("select p from Person p where p.email=?1 and p.password=?2")
	public Person login(String email, String password);
		
}
