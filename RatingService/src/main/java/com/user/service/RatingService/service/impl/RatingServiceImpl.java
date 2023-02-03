package com.user.service.RatingService.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.service.RatingService.entity.Rating;
import com.user.service.RatingService.repo.RatingRepo;
import com.user.service.RatingService.service.RatingService;

@Service
public class RatingServiceImpl implements RatingService{
    
	@Autowired
	private RatingRepo ratingRepo;
	
	@Override
	public Rating create(Rating rating) {
		return ratingRepo.save(rating);
	}

	@Override
	public List<Rating> getAllRating() {
       return ratingRepo.findAll();
	}

	@Override
	public List<Rating> getRatingByUserId(Integer userId) {
		return ratingRepo.findByUserId(userId);
	}

	@Override
	public List<Rating> getRatingByHoteId(Integer hotelId) {
		return ratingRepo.findByHotelId(hotelId);
	}

}
