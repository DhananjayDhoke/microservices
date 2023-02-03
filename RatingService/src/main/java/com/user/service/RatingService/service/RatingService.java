package com.user.service.RatingService.service;

import java.util.List;

import com.user.service.RatingService.entity.Rating;

public interface RatingService {
   
	// create rating 
	Rating create (Rating rating);
	
	// get all rating 
	List<Rating> getAllRating ();
	
	//get all By userId 
	List<Rating> getRatingByUserId (Integer userId);
	
	// get rating by hotelId 
	List<Rating> getRatingByHoteId (Integer hotelId);
	
}
