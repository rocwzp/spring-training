/**
 * 
 */
package com.springmvcapp.web.rest.domain;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author user
 *
 */
@XmlRootElement
public class Persons {
	
	private List<Person> persons;
	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}
	@XmlElementWrapper(name="persons")
	@XmlElement(name="person")
	public List<Person> getPersons() {
		return persons;
	}
}
