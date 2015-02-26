package com.sivalabs.springtraining;

import java.util.List;

import com.sivalabs.springtraining.entity.Person;
import com.sivalabs.springtraining.services.PersonService;

public class Main {

	public static void main(String[] args) {
		PersonService personService = new PersonService();
		
		List<Person> resultList = personService.findAll();
		
		System.out.println("Persons: "+resultList);
		for (Person person : resultList) {
			System.out.println(person);
		}
		/*
		Person p1 = new Person();
		p1.setName("prasad");
		p1 = personService.create(p1);
		
		p1.setAddress("Hyderabad");
		p1.setEmail("siva@gmail.com");
		personService.update(p1);
		*/
		personService.delete(2);
		
		personService.destroy();
	}

}
