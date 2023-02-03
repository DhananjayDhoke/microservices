package com.user.service.hotelService.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user.service.hotelService.entity.Hotel;

public interface HotelRepo extends JpaRepository<Hotel, Integer>{
  
	
}
