/**
 * 
 */
package com.sivalabs.springtraining.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.sivalabs.springtraining.UserDao;
import com.sivalabs.springtraining.UserService;

/**
 * @author user
 *
 */
@Configuration
@ComponentScan(basePackages="com.sivalabs.springtraining")
@Import(DaoConfig.class)
//@ImportResource(value={"classpath:applicationContext.xml","classpath:servicesContext.xml"})
public class AppConfig {
	
	@Autowired
	private UserDao userDao;
	
	/*
	@Bean
	public UserService userService() {
		UserService userService = new UserService(userDao());
		return userService;
	}*/
	
	@Bean
	public UserService userService(UserDao userDao) {
		UserService userService = new UserService(userDao);
		return userService;
	}
	

}
