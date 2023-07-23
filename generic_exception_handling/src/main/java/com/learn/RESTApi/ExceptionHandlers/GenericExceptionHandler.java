package com.learn.RESTApi.ExceptionHandlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.learn.RESTApi.CustomExceptions.ExceptionManager;
import com.learn.RESTApi.Models.ExceptionResponse;


/*
 * @ControllerAdvice is like an inspector/filter 
 * it provides real time use of AOP (Aspect oriented programming)
 * @ControllerAdvice is a specialization of the @Component annotation 
 * which allows to handle exceptions across the whole application in one global handling component. 
 * It can be viewed as an intercepter of exceptions thrown by methods annotated with 
 * @RequestMapping, @Respository, @Component, @Service and similar.*/

@ControllerAdvice
public class GenericExceptionHandler {
	//Add an exception handler using @ExceptionHandleer
	
	@ExceptionHandler
	public ResponseEntity<ExceptionResponse> handleException(ExceptionManager e) {
		
		ExceptionResponse exception = new ExceptionResponse();
		//create a studentErrorResponse
		
		
		exception.setStatus(e.getStatusCode());
		exception.setMessage(e.getMessage());
		exception.setTimeStamp(System.currentTimeMillis());
		
		// return ResponseEntity
		/*
		 * "ResponseEntity" is a class provided by the Spring Framework in Java that represents the 
		 * HTTP response returned by a RESTful API end point. It encapsulates the response status, headers, and body, 
		 * allowing you to customize and control the response sent back to the client.
		 */
		return new ResponseEntity<>(exception, HttpStatus.NOT_FOUND);
		/* 
		 * =>  response might look like this :-
		 * {
		 * "status": 404,
		 * "message":"Student id not found.",
		 * "timeStamp":156483900920438
		 * } 
		 */
	}
	
	
	// This is for handling any type of generic exception which are not handle by the programmer.
	@ExceptionHandler
	public ResponseEntity<ExceptionResponse> handleException(Exception e) {
		
		ExceptionResponse exception = new ExceptionResponse();
		//create a studentErrorResponse
	
		exception.setStatus(HttpStatus.BAD_REQUEST.value());
		exception.setMessage(e.getMessage());
		exception.setTimeStamp(System.currentTimeMillis());
		
		// return ResponseEntity
		/*
		 * "ResponseEntity" is a class provided by the Spring Framework in Java that represents the 
		 * HTTP response returned by a RESTful API end point. It encapsulates the response status, headers, and body, 
		 * allowing you to customize and control the response sent back to the client.
		 */
		return new ResponseEntity<>(exception, HttpStatus.NOT_FOUND);
	}
	
	
}
