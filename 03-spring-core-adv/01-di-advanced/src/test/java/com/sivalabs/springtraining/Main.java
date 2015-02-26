package com.sivalabs.springtraining;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sivalabs.springtraining.events.DatabaseFailureEvent;

public class Main {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		System.setProperty("spring.profiles.active", "prod,dev");
		//ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		
		ApplicationEvent dbFailEvent = new DatabaseFailureEvent("Unable to open Connection");
		ctx.publishEvent(dbFailEvent );
		
		MyBean myBean = ctx.getBean(MyBean.class);
		myBean.doSomething();
		
	}

}
