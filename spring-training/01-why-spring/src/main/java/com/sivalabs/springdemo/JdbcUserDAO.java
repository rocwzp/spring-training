/**
 * 
 */
package com.sivalabs.springdemo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

/**
 * @author skatam
 *
 */
public class JdbcUserDAO implements UserDAO
{
	private DataSource dataSource;
	public JdbcUserDAO(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Override
	public List<User> getUsers() {
		List<User> users = new ArrayList<User>();
		try {
			Connection connection = dataSource.getConnection();
			PreparedStatement pstmt = connection.prepareStatement("select * from users");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				User user = new User(rs.getInt("id"), rs.getString("name"));
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return users;
	}

}
