/**
 * 
 */
package com.sivalabs.springapp.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

/**
 * @author Siva
 *
 */
@Configuration
@ComponentScan(basePackages={"com.sivalabs.springapp"},
excludeFilters=@ComponentScan.Filter(type=FilterType.REGEX, pattern="com.sivalabs.springapp.web.*"))
@PropertySource(value = { "classpath:application.properties" })
public class AppConfig {

	@Autowired
	private Environment env;

	@Bean
	public static PropertySourcesPlaceholderConfigurer placeHolderConfigurer()
	{
		return new PropertySourcesPlaceholderConfigurer();
	}

}
