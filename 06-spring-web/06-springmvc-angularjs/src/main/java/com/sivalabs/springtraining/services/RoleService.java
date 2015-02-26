/**
 * 
 */
package com.sivalabs.springtraining.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sivalabs.springtraining.entities.Role;
import com.sivalabs.springtraining.repositories.RoleRepository;

/**
 * @author Siva
 *
 */
@Service
@Transactional
public class RoleService 
{
	@Autowired
	private RoleRepository roleRepository;
	
	public List<Role> findAll() {
		return roleRepository.findAll();
	}
}
