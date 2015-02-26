package com.sivalabs.springtraining.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sivalabs.springtraining.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Serializable>
{

}
