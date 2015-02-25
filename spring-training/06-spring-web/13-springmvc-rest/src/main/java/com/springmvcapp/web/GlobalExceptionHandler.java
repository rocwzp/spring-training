/**
 * 
 */
package com.springmvcapp.web;

import java.io.IOException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author user
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(IOException.class)
    public String handleIOException(IOException ex) {
        ex.printStackTrace();
        return "gloablError";
    }
	
	@ExceptionHandler(Exception.class)
    public String handleException(Exception ex) {
		ex.printStackTrace();
		return "gloablError";
    }
    
}
