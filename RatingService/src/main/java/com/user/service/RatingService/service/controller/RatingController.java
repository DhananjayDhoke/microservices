package com.user.service.RatingService.service.controller;

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

import com.user.service.RatingService.entity.Rating;
import com.user.service.RatingService.service.RatingService;


@RestController
@RequestMapping("/api/v1/rating")
public class RatingController {
    
	@Autowired
	private RatingService ratingService;
	
	@PostMapping
	public ResponseEntity<Rating> createRatingHandler(@RequestBody Rating rating){
		
		Rating createRating = ratingService.create(rating);
		
		return new ResponseEntity<>(createRating,HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity< List<Rating>> getAllRatingHandler (){
		
	   List<Rating> allRating = ratingService.getAllRating();
		
		return new ResponseEntity<>(allRating, HttpStatus.OK);
	}
	
	@GetMapping("/user/{userId}")
	public ResponseEntity<List<Rating>> getByUserIdHandler (@PathVariable Integer userId){
		
		List<Rating> ratingByUserId = ratingService.getRatingByUserId(userId);
		
		return new ResponseEntity<>(ratingByUserId, HttpStatus.OK);
	}
	
	@GetMapping("/hotel/{hotelId}")
	public ResponseEntity<List<Rating>> getByHotelIdHandler (@PathVariable Integer hotelId){
		
		List<Rating> ratingByHoteId = ratingService.getRatingByHoteId(hotelId);
		
		return new ResponseEntity<>(ratingByHoteId, HttpStatus.OK);
	}
	
}
