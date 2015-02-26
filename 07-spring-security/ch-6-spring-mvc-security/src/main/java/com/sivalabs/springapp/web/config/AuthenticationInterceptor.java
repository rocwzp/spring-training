/**
 * 
 */
package com.sivalabs.springapp.web.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.sivalabs.springapp.entities.User;
import com.sivalabs.springapp.services.UserService;

/**
 * @author Siva
 *
 */
@Component("authenticationInterceptor")
public class AuthenticationInterceptor extends HandlerInterceptorAdapter
{
	@Autowired
	private UserService userService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		if(request.getSession().getAttribute("LOGIN_USER") != null)
		{
			//TODO;
		}
		return true;
	}
	
	public UserDetails getCurrentUser()
	{
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    if (principal instanceof UserDetails) 
	    {
	    	String email = ((UserDetails) principal).getUsername();
	    	User loginUser = userService.findUserByEmail(email);
	    	return new SecurityUser(loginUser);
	    }

	    return null;
	}
	
}
