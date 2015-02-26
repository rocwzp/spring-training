/**
 * 
 */
package com.sivalabs.springtraining;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author user
 *
 */
@Repository
public class UserDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@PostConstruct
	void init()
	{
		String sql = "create table users(id integer, name varchar2(20), email varchar2(20), dob date)";
		jdbcTemplate.update(sql);
		
	}
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public User create(User user) {
		String sql = "insert into users(id, name, email, dob) values(?,?,?,?)";
		jdbcTemplate.update(sql, new Object[]{user.getId(), user.getName(), user.getEmail(), user.getDob()});
		
		
		return user;
	}
	
	@Transactional(readOnly=true)
	public User findById(Integer userId) {
		String sql = "select * from users where id=?";
		return jdbcTemplate.queryForObject(sql, new Object[]{userId}, new UserRowMapper());
	}
	
	@Transactional(readOnly=true)
	public List<User> findAll() {
		String sql = "select * from users";
		return jdbcTemplate.query(sql, new UserRowMapper());
	}
	
	@Transactional
	public void update(User user) {
		String sql = "update users set email=? where id=?";
		jdbcTemplate.update(sql, new Object[]{user.getEmail(), user.getId()});
	}
	
	@Transactional
	public void delete(Integer userId) {
		String sql = "delete from users where id=?";
		jdbcTemplate.update(sql, new Object[]{userId});
	}
	
	@Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.DEFAULT)
	public void create(List<User> users) throws MyAppException {
		int counter = 0;
		for (User user : users) {
			/*
			String sql = "insert into users(name, email, dob) values(?,?,?)";
			jdbcTemplate.update(sql, new Object[]{user.getName(), user.getEmail(), user.getDob()});
			if(counter == 1){
				//throw new RuntimeException("Testing");
				throw new MyAppException();
			}
			counter++;
			*/
			create(user);
			if(counter == 1){
				throw new RuntimeException("Testing");
				//throw new MyAppException();
			}
			counter++;
			
			
		}
	}
}

class UserRowMapper implements RowMapper<User>
{

	@Override
	public User mapRow(ResultSet rs, int arg1) throws SQLException {
		User user = new User();
		user.setId(rs.getInt("id"));
		user.setName(rs.getString("name"));
		user.setEmail(rs.getString("email"));
		user.setDob(rs.getDate("dob"));
		return user;		
	}
	
}
