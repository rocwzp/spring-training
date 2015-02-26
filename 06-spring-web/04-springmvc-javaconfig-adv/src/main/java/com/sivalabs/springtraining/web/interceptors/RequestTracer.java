/**
 * 
 */
package com.sivalabs.springtraining.web.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * @author user
 *
 */
public class RequestTracer extends HandlerInterceptorAdapter
{
	private static final Logger LOGGER = LoggerFactory.getLogger(RequestTracer.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception 
	{
		LOGGER.debug("==============================================");
		LOGGER.debug("Request came from "+request.getRemoteHost());
		LOGGER.debug("URI "+request.getRequestURI());
		LOGGER.debug("==============================================");
		return super.preHandle(request, response, handler);
	}
	
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		super.postHandle(request, response, handler, modelAndView);
	}
}
