package com.user.service.hotelService.service;

import java.util.List;

import com.user.service.hotelService.entity.Hotel;

public interface HotelService {
  
	// create hotel
	Hotel create (Hotel hotel);
	
	// get all hotel
	List<Hotel> getAllHotel ();
	
	// get hotel by id 
	Hotel getById (Integer hotelId);
}
