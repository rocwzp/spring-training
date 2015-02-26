/**
 * 
 */
package com.sivalabs.springtraining.events;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author user
 *
 */
@Component
public class DatabaseFailureEventListener implements ApplicationListener<DatabaseFailureEvent>{

	@Override
	public void onApplicationEvent(DatabaseFailureEvent event) {
		System.err.println("Database Failure Encountered:"+event.getError());
	}

}
