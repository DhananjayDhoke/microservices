package com.user.service.Userservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.service.Userservice.entity.User;
import com.user.service.Userservice.service.UserService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/user")
@Slf4j
public class UserController {
    
	@Autowired
	private UserService userService;
	
	@PostMapping
	public ResponseEntity<User> createUserHandler (@RequestBody User user){
		
		User created = userService.create(user);
		
		return new ResponseEntity<>(created, HttpStatus.OK);
	}
	
	@GetMapping("{id}")
    //@CircuitBreaker(name = "ratingHotelBreker",fallbackMethod = "ratingHotelFallback")
	@RateLimiter(name = "userRateLimiter",fallbackMethod = "ratingHotelFallback")
	public ResponseEntity<User> getUserHandler (@PathVariable Integer id){
		
		User userById = userService.getUserById(id);
		
		return new ResponseEntity<>(userById, HttpStatus.OK);
	}
	
	// fallback method for circuit breaker
	public ResponseEntity<User> ratingHotelFallback(Integer id, Exception ex){
		log.info("fallback method is executed because service is down ",ex.getMessage());
		
		User user = User.builder()
		.email("dummyuser@gmail.com")
		.name("dummy")
		.about("this is dummy user for fallback service")
		.userId(1234)
		.build();
		
		return new ResponseEntity<>(user,HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity< List<User>> getAllUserHandler (){
		
	 List<User> allUser = userService.getAllUser();
		
		return new ResponseEntity<>(allUser, HttpStatus.OK);
	}
	
	
}
