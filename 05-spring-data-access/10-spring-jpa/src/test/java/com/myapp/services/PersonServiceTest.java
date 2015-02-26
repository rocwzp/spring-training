package com.myapp.services;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.myapp.config.AppConfig;
import com.myapp.entities.Person;


public class PersonServiceTest {

	public static void main(String[] args) {
		//ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		PersonService personService = context.getBean(PersonService.class);
		
		List<Person> resultList = personService.findAll();
		
		System.out.println("Persons: "+resultList);
		for (Person person : resultList) {
			System.out.println(person);
		}
		
		Person person = personService.login("siva@gmail.com", "siva12");
		System.out.println("Login:"+person);
		/*
		Person p1 = new Person();
		p1.setName("Srivathsala");
		p1 = personService.create(p1);
		
		p1.setAddress("Hyderabad, TG");
		p1.setEmail("sri@gmail.com");
		personService.update(p1);
		*/
		//personService.delete(3);
		
	}

}
