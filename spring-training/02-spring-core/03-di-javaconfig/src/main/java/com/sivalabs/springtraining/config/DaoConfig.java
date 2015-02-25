/**
 * 
 */
package com.sivalabs.springtraining.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sivalabs.springtraining.UserDao;
import com.sivalabs.springtraining.UserDaoImpl;

/**
 * @author user
 *
 */
@Configuration
public class DaoConfig {

	@Bean
	public UserDao userDao() {
		return new UserDaoImpl();
	}
}
