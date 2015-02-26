/**
 * 
 */
package com.sivalabs.springtraining.events;

import org.springframework.context.ApplicationEvent;

/**
 * @author user
 *
 */
public class DatabaseFailureEvent extends ApplicationEvent
{
	private static final long serialVersionUID = 1L;
	private String error;
	
	public DatabaseFailureEvent(Object source) {
		super(source);
		this.error = (String) source;
	}
	
	public void setError(String error) {
		this.error = error;
	}
	public String getError() {
		return error;
	}
}
