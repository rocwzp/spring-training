/**
 * 
 */
package com.sivalabs.springtraining.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sivalabs.springtraining.entities.User;

/**
 * @author user
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
