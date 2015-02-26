package com.sivalabs.springapp.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sivalabs.springapp.entities.User;

public interface UserRepository extends JpaRepository<User, Serializable>{

	@Query("select u from User u where u.email=?1 and u.password=?2")
	User login(String email, String password);

	User findByEmailAndPassword(String email, String password);

	@Query("SELECT u FROM User u WHERE u.name LIKE %:query% or u.email LIKE %:query%")
	List<User> searchUsers(@Param("query") String query);

}
