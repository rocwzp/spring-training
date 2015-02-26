package com.myapp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserServiceTest {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		//ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		UserService userService = ctx.getBean(UserService.class);
		System.out.println(userService.login("siva", "pwd"));
		//userService.save("tetsuser");
	}

}
