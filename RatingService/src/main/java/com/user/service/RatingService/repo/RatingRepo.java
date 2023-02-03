package com.user.service.RatingService.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user.service.RatingService.entity.Rating;

public interface RatingRepo extends JpaRepository<Rating, Integer> {
  
	List<Rating> findByUserId (Integer userId);
	List<Rating> findByHotelId (Integer hotelId);
}
