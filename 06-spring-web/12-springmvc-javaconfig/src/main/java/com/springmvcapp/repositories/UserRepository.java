/**
 * 
 */
package com.springmvcapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springmvcapp.entities.User;

/**
 * @author user
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
