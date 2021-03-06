/**
 * 
 */
package com.sivalabs.springtraining.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sivalabs.springtraining.entities.Role;
import com.sivalabs.springtraining.services.RoleService;

/**
 * @author Siva
 *
 */
@RestController
@RequestMapping(value="/rest/roles/", produces=MediaType.APPLICATION_JSON_VALUE)
public class RoleController {

	@Autowired
	private RoleService roleService;
	
	@RequestMapping("")
	public List<Role> findAllRoles() {
		return roleService.findAll();
	}
}
