package com.user.service.Userservice.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
   
	@ExceptionHandler(ResourceNotFound.class)
	ResponseEntity<CustomizeErrorDetails> handelerResourceNotFoundException (ResourceNotFound ex){
		
		String message = ex.getMessage();
		
		CustomizeErrorDetails responce = CustomizeErrorDetails.builder().message(message).build();
		
		return new ResponseEntity<CustomizeErrorDetails>(responce,HttpStatus.NOT_FOUND);
	}
	
	
}
