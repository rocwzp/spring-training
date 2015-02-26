/**
 * 
 */
package com.sivalabs.springtraining.events;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * @author user
 *
 */
@Component
public class ContextStartedEventListener implements ApplicationListener<ContextRefreshedEvent>{

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		System.out.println("************* ContextRefreshedEvent****************");
	}

}
