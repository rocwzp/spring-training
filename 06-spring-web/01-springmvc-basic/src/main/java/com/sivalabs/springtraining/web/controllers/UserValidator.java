package com.sivalabs.springtraining.web.controllers;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.sivalabs.springtraining.domain.User;

@Component
public class UserValidator implements Validator
{

	public boolean supports(Class<?> clazz) {
		return clazz.isAssignableFrom(User.class);
	}

	public void validate(Object object, Errors errors) {
		User user = (User) object;
		if(user.getEmail().equals("")){
			errors.reject("email", "Email should not be blank");
		}
		if(user.getAge() < 1){
			errors.reject("age", "Age should be greater than 0");
		}
	}

}
