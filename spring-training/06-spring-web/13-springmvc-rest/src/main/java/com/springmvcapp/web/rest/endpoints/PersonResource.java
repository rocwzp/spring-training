/**
 * 
 */
package com.springmvcapp.web.rest.endpoints;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springmvcapp.web.rest.domain.Person;
import com.springmvcapp.web.rest.domain.Persons;

/**
 * @author user
 *
 */
@RestController
@RequestMapping(value="/persons", produces={"application/xml", "application/json"}, 
								consumes={"application/xml", "application/json"})
public class PersonResource {

	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public Persons findAll() {
		List<Person> personsList = Arrays.asList(
					new Person(1, "admin", "admin@gmail.com"), 
					new Person(2, "siva", "sivA@gmail.com"), 
					new Person(3, "test", "test@gmail.com")					
		);
		Persons persons = new Persons();
		persons.setPersons(personsList);
		return persons;
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public Person findPerson(@PathVariable("id")int id) {
		return new Person(id, "admin", "admin@gmail.com");
				
	}
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public ResponseEntity<Person> createPerson(@RequestBody Person person) {
		System.out.println("Creating person :"+person);
		ResponseEntity<Person> response = new ResponseEntity<Person>(person, HttpStatus.CREATED );
		return response;
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public Person updatePerson(@RequestBody Person person) {
		System.out.println("Update person :"+person);
		return person;
	}
	
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deletePerson(@PathVariable("id")int id) {
		System.out.println("delete person :"+id);
		ResponseEntity<Void> response = new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return response;
	}
	
	
	
}
