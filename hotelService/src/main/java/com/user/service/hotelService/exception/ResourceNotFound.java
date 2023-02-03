package com.user.service.hotelService.exception;

public class ResourceNotFound extends RuntimeException{
   
	public ResourceNotFound(String message) {
		super(message);
	}
	
	public ResourceNotFound() {
		super("Resource Not found");
	}
}
