/**
 * 
 */
package com.sivalabs.springtraining.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sivalabs.springtraining.entities.User;

/**
 * @author user
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	//public Person findByEmailAndPassword(String email, String password);
	
	@Query("select u from User u where u.email=?1 and u.password=?2")
	public User login(String email, String password);
		
}
