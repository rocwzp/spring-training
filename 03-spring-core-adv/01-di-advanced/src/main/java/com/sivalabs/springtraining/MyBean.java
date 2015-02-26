/**
 * 
 */
package com.sivalabs.springtraining;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * @author user
 *
 */
@Component
@Profile({"dev","prod"})
public class MyBean {

	@Autowired
	private Environment env;
	
	@Value("${jdbc.username}")
	private String jdbcUserName;
	
	@Value("${author}")
	private String author;
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public void doSomething() {
		System.out.println("Author:"+author);
		System.out.println("jdbc.driverClassName: "+env.getProperty("jdbc.driverClassName"));
		System.out.println("jdbcUsername: "+jdbcUserName);
		
		
	}
	
}
