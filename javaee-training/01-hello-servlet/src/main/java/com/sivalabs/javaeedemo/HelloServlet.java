package com.sivalabs.javaeedemo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/hello")
public class HelloServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	
	@Inject
	private HelloService helloService;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) 
								throws ServletException, IOException 
	{
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		String hello = helloService.sayHello(name);
		out.print(hello);
	}

}
