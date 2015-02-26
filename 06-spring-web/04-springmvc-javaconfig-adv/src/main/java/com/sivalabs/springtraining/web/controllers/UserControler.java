/**
 * 
 */
package com.sivalabs.springtraining.web.controllers;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.ConstraintViolationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sivalabs.springtraining.entities.User;
import com.sivalabs.springtraining.services.UserService;
import com.sivalabs.springtraining.web.validators.UserValidator;

/**
 * @author user
 *
 */
@Controller
public class UserControler 
{
	private static final Logger LOGGER = LoggerFactory.getLogger(UserControler.class);

	@Autowired
	private UserService userService;
	
	@Autowired
	private UserValidator userValidator;
	

	@InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
	
	@RequestMapping(value="/index")
	public String index(Model model) {
		return "index";
	}

	@RequestMapping(value="/showUsers")
	public String showUsers(Model model) {
		model.addAttribute("users", userService.findAllUsers());
		return "users";
	}
	
	@RequestMapping(value="/showUser")
	public String showUser(@RequestParam("id")int id, Model model) {
		model.addAttribute("user", userService.findUserById(id));
		return "userDetails";
	}
	
	@RequestMapping(value="/createUser", method=RequestMethod.GET)
	public String createUserForm(Model model) {
		model.addAttribute("user", new User());
		return "newUser";
	}
	
	@RequestMapping(value="/createUser", method=RequestMethod.POST)
	public String createUser(@ModelAttribute User user, Errors errors, RedirectAttributes flash) {
		this.userValidator.validate(user, errors);
		if(errors.hasErrors()){
			return "newUser";
		}
		userService.createUser(user);
		flash.addFlashAttribute("msg", "User created successfully");
		return "redirect:showUsers";
	}
	
	@RequestMapping(value="/updateUser", method=RequestMethod.POST)
	public String updateUser(@Validated User user, Errors errors, Model model, RedirectAttributes flash) {
		if(errors.hasErrors()){
			return "userDetails";
		}
		userService.updateUser(user);
		flash.addFlashAttribute("msg", "User updated successfully");
		return "redirect:showUsers";
	}
	
	@RequestMapping(value="/deleteUser", method=RequestMethod.DELETE)
	public String deleteUser(@RequestParam("id")int id, Model model, RedirectAttributes flash) {
		userService.deleteUser(id);
		flash.addFlashAttribute("msg", "User deleted successfully");
		return "redirect:showUsers";
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
    public String handleConstraintViolationException(ConstraintViolationException ex) {
		LOGGER.error("=====================================");
		LOGGER.error(ex.getMessage());
		LOGGER.error("=====================================");
        return "error";
    }
    
	@ExceptionHandler(IOException.class)
    public String handleIOException(IOException ex) {
		LOGGER.error("=====================================");
		LOGGER.error(ex.getMessage());
		LOGGER.error("=====================================");
        return "error";
    }
}
