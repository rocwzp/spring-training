/**
 * 
 */
package com.springmvcapp.web.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.springmvcapp.domain.User;
import com.springmvcapp.services.EchoService;

/**
 * @author user
 *
 */
@Controller
public class EchoControler {

	@Autowired
	private EchoService echoService;
	
	@Autowired
	private UserValidator userValidator;
	
	@RequestMapping(value="/echo")
	public ModelAndView echo(HttpServletRequest request, HttpServletResponse response) {
		String name = request.getParameter("name");
		System.out.println("EchoControler: name="+name);
		String echo = echoService.echo(name);
		//request.setAttribute("Echo", echo);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("echo");
		mav.addObject("Echo", echo);
		mav.addObject("Echo1", echo+echo);
		
		return mav;
	}
	
	@RequestMapping("/ping")
	public String ping(@RequestParam(value="name") String name, 
			@RequestParam(value="addr", required=false, defaultValue="Bangalore") String addr, 
			@RequestParam("age") int age,
			Model model) {
		//String name = request.getParameter("name");
		model.addAttribute("MyName",name);
		model.addAttribute("Addr",addr);
		model.addAttribute("Age",age);
		
		return "ping";
	}
	
	@RequestMapping(value="/showUser", headers="Company=ABCD", params="age=25")
	public String showUser(User user, Model model) {
		System.out.println(user);
		model.addAttribute("user", user);
		return "ping";
	}
	
	@RequestMapping(value="/index")
	public String index(Model model) {
		User user = new User();
		user.setAge(30);
		user.setEmail("admin@gmail.com");
		model.addAttribute("user", user);
		return "index";
	}
	
	@InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }
	
	@RequestMapping(value="/saveUser", method=RequestMethod.POST)
	public String saveUser(@Validated User user, BindingResult result, Model model) {
		System.out.println("Save User:"+user);
		//userValidator.validate(user, errors);
		//if(errors.h)
		model.addAttribute("user", user);
		
		return "index";
	}
	
	
}
