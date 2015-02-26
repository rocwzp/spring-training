package com.sivalabs.springtraining;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sivalabs.springtraining.AppConfig;
import com.sivalabs.springtraining.User;
import com.sivalabs.springtraining.UserService;

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
