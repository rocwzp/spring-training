/**
 * 
 */
package com.myapp;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author user
 *
 */
@Configuration
@ComponentScan(basePackages="com.myapp")
@EnableAspectJAutoProxy
public class AppConfig {

}
