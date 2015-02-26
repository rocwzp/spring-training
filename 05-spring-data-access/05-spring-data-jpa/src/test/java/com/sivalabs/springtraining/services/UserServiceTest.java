package com.sivalabs.springtraining.services;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sivalabs.springtraining.AppConfig;
import com.sivalabs.springtraining.entities.User;


public class UserServiceTest {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		UserService userService = context.getBean(UserService.class);
		
		List<User> resultList = userService.findAll();
		
		System.out.println("Users: "+resultList);
		for (User user : resultList) {
			System.out.println(user);
		}
		
		User user = userService.login("siva@gmail.com", "siva12");
		System.out.println("Login:"+user);
		/*
		User p1 = new User();
		p1.setName("Prasad");
		p1 = userService.create(p1);
		
		p1.setAddress("Hyderabad, TG");
		p1.setEmail("sprasad@gmail.com");
		userService.update(p1);
		*/
		//userService.delete(3);
		
	}

}
