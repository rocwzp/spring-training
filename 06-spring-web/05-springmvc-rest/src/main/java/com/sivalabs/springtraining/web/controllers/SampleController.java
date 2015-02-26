package com.sivalabs.springtraining.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/app/")
public class SampleController {

	
	@RequestMapping(value="test")
	public String test() {
		return "";
	}
	
	@RequestMapping(value="test1")
	public String test1() {
		return "";
	}
	
	@RequestMapping(value="test2")
	public String test2() {
		return "";
	}
}
