package com.myapp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UserServiceTest {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		UserService userService = ctx.getBean(UserService.class);
		String status = userService.login("", null);
		System.out.println(status);
	}

}
