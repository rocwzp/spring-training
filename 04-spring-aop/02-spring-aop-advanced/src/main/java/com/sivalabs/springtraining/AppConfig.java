/**
 * 
 */
package com.sivalabs.springtraining;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author user
 *
 */
@Configuration
@ComponentScan(basePackages="com.sivalabs.springtraining")
@EnableAspectJAutoProxy
public class AppConfig {

}
