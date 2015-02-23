/**
 * 
 */
package com.sivalabs.springdemo;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author skatam
 *
 */
public class UserServiceTest 
{
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		//ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext-test.xml");
		UserService userService = ctx.getBean(UserService.class);
		List<User> users = userService.getUsers();
		for (User user : users) {
			System.out.println(user);
		}
	}
}
