/**
 * 
 */
package com.sivalabs.springapp;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.stereotype.Component;

/**
 * @author katsi02
 *
 */
@Component
public class DBInitializer 
{
	@Autowired
	private DataSource dataSource;
	
	@Value("${init-db:false}")
	private String initDatabase;
	
	@Bean
	public DataSourceInitializer dataSourceInitializer() 
	{
		DataSourceInitializer dataSourceInitializer = new DataSourceInitializer();
		dataSourceInitializer.setDataSource(dataSource);
		
		ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator();
		databasePopulator.addScript(new ClassPathResource("db.sql"));
		
		dataSourceInitializer.setDatabasePopulator(databasePopulator);
		dataSourceInitializer.setEnabled(Boolean.parseBoolean(initDatabase));
		
		return dataSourceInitializer;
	}	
}
