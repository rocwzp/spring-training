package com.myapp.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.myapp.config.AppConfig;
import com.myapp.domain.Person;

public class PersonDAOTests {

	public static void main(String[] args) throws Exception {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		PersonDAO personDAO = ctx.getBean(PersonDAO.class);
		
		
		Person sri = new Person();
		sri.setId(2);
		sri.setName("Srivathsala");
		sri.setEmail("sri@gmail.com");
		sri.setDob(new Date());
		
		personDAO.create(sri);
		
		List<Person> persons = personDAO.findAll();
		for (Person person : persons) {
			System.out.println(person);
		}
		System.out.println("----------------------");
		Person person = personDAO.findById(2);
		System.out.println(person);
		System.out.println("---------------------------");
		/*
		
		
		persons = personDAO.findAll();
		for (Person p : persons) {
			System.out.println(p);
		}
		*/
		
		List<Person> personsList = new ArrayList<Person>();
		personsList.add(new Person(null, "User1", "u1@gmail.com", null));
		personsList.add(new Person(null, "User2", "u2@gmail.com", null));
		personsList.add(new Person(null, "User3", "u3@gmail.com", null));
		personDAO.create(personsList);
		
	}

}
