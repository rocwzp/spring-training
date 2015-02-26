package com.sivalabs.springtraining;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sivalabs.springtraining.AppConfig;
import com.sivalabs.springtraining.User;
import com.sivalabs.springtraining.UserDAO;

public class UserDAOTests {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		UserDAO userDAO = ctx.getBean(UserDAO.class);
		
		
		User u1 = new User();
		u1.setId(2);
		u1.setName("Siva");
		u1.setEmail("siva@gmail.com");
		u1.setDob(new Date());
		
		userDAO.create(u1);
		
		List<User> users = userDAO.findAll();
		for (User user : users) {
			System.out.println(user);
		}
		System.out.println("----------------------");
		User user = userDAO.findById(2);
		System.out.println(user);
		System.out.println("---------------------------");
				
		try {
			List<User> usersList = new ArrayList<User>();
			usersList.add(new User(null, "User1", "u1@gmail.com", null));
			usersList.add(new User(null, "User2", "u2@gmail.com", null));
			usersList.add(new User(null, "User3", "u3@gmail.com", null));
			userDAO.create(usersList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		users = userDAO.findAll();
		for (User u : users) {
			System.out.println(u);
		}
		
	}

}
