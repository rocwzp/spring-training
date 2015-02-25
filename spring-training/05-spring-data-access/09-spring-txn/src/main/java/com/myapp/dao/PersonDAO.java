/**
 * 
 */
package com.myapp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.myapp.MyAppException;
import com.myapp.domain.Person;

/**
 * @author user
 *
 */
@Repository
public class PersonDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@PostConstruct
	void init()
	{
		String sql = "create table persons(id integer, name varchar2(20), email varchar2(20), dob date)";
		jdbcTemplate.update(sql);
		
	}
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public Person create(Person person) {
		String sql = "insert into persons(id, name, email, dob) values(?,?,?,?)";
		jdbcTemplate.update(sql, new Object[]{person.getId(), person.getName(), person.getEmail(), person.getDob()});
		
		
		return person;
	}
	
	@Transactional(readOnly=true)
	public Person findById(Integer personId) {
		String sql = "select * from persons where id=?";
		return jdbcTemplate.queryForObject(sql, new Object[]{personId}, new PersonRowMapper());
	}
	
	@Transactional(readOnly=true)
	public List<Person> findAll() {
		String sql = "select * from persons";
		return jdbcTemplate.query(sql, new PersonRowMapper());
	}
	
	@Transactional
	public void update(Person person) {
		String sql = "update persons set email=? where id=?";
		jdbcTemplate.update(sql, new Object[]{person.getEmail(), person.getId()});
	}
	
	@Transactional
	public void delete(Integer personId) {
		String sql = "delete from persons where id=?";
		jdbcTemplate.update(sql, new Object[]{personId});
	}
	
	@Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.DEFAULT)
	public void create(List<Person> persons) throws MyAppException {
		int counter = 0;
		for (Person person : persons) {
			/*
			String sql = "insert into persons(name, email, dob) values(?,?,?)";
			jdbcTemplate.update(sql, new Object[]{person.getName(), person.getEmail(), person.getDob()});
			if(counter == 1){
				//throw new RuntimeException("Testing");
				throw new MyAppException();
			}
			counter++;
			*/
			create(person);
			if(counter == 1){
				//throw new RuntimeException("Testing");
				throw new MyAppException();
			}
			counter++;
			
			
		}
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
