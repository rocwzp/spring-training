/**
 * 
 */
package com.sivalabs.springdemo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author skatam
 *
 */
public class MockUserDAO implements UserDAO
{

	@Override
	public List<User> getUsers() {
		List<User> users = new ArrayList<>();
		users.add(new User(1, "John"));
		users.add(new User(2, "Rambo"));
		users.add(new User(3, "James"));
		users.add(new User(4, "Bond"));
		return users;
	}

}
