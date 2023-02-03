package com.user.service.Userservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rating {
   
	private Integer ratingId;
	
	private Integer userId;
	
	private Integer hotelId;
	
	private Integer rating;
	
	private String feedback;
	
	private Hotel hotel;
	
}
