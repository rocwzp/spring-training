package com.sivalabs.springtraining;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class UserDaoImpl implements UserDao {
	
	private static final Map<Integer, User> USER_MAP = new HashMap<>();
	private static final AtomicInteger ID_GEN = new AtomicInteger(0);
	
	public UserDaoImpl() {
		System.out.println("-----UserDaoImpl------");
	}

	static
	{
		User admin = new User(ID_GEN.incrementAndGet(), "Administrator", "admin@gmail.com", new Date());
		User test = new User(ID_GEN.incrementAndGet(), "Test", "test@gmail.com", null);
		USER_MAP.put(admin.getId(), admin);
		USER_MAP.put(test.getId(), test);
	}
	
	@Override
	public List<User> findAll() {
		return new ArrayList<>(USER_MAP.values());
	}

	@Override
	public User create(User user) {
		user.setId(ID_GEN.incrementAndGet());
		USER_MAP.put(user.getId(), user);
		return user;
	}

	@Override
	public User findUserById(int id) {
		return USER_MAP.get(id);
	}

}
