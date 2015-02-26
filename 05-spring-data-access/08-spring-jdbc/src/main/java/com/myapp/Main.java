package com.myapp;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class Main {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		JdbcTemplate jdbcTemplate = ctx.getBean(JdbcTemplate.class);
		List<Person> persons = jdbcTemplate.query("select * from persons", new PersonRowMapper());
		System.out.println("Rows: "+persons.size());
		for (Person person : persons) {
			System.out.println(person);
		}
		
		//jdbcTemplate.update("");
		
	}

}

class PersonRowMapper implements RowMapper<Person>
{

	@Override
	public Person mapRow(ResultSet rs, int arg1) throws SQLException {
		Person p = new Person();
		p.setId(rs.getInt("id"));
		p.setName(rs.getString("name"));
		p.setEmail(rs.getString("email"));
		p.setDob(rs.getDate("dob"));
		return p;		
	}
	
}

class Person
{
	private int id;
	private String name;
	private String email;
	private Date dob;
	
	
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", email=" + email
				+ ", dob=" + dob + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	
	
}