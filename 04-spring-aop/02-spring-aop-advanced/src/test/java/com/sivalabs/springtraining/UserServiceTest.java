package com.sivalabs.springtraining;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sivalabs.springtraining.AppConfig;
import com.sivalabs.springtraining.UserService;

public class UserServiceTest {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		UserService userService = ctx.getBean(UserService.class);
		String status = userService.login("", null);
		System.out.println(status);
	}
}
