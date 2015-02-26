package com.sivalabs.springapp;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	@SuppressWarnings("resource")
	public static void main(String[] args) 
	{
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		UserService userService = ctx.getBean(UserService.class);
		List<User> users = userService.findAll();
		for (User user : users) 
		{
			System.out.println(user);
		}
	}

}
