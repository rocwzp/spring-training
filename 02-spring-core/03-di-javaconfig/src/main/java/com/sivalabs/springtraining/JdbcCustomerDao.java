/**
 * 
 */
package com.sivalabs.springtraining;

import org.springframework.stereotype.Repository;

/**
 * @author user
 *
 */
@Repository
public class JdbcCustomerDao implements CustomerDao{

	@Override
	public boolean login(String username, String pwd) {
		return "admin".equals(username) && "admin".equals(pwd);
	}

}
