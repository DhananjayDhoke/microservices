package com.user.service.hotelService.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.service.hotelService.entity.Hotel;
import com.user.service.hotelService.exception.ResourceNotFound;
import com.user.service.hotelService.repo.HotelRepo;
import com.user.service.hotelService.service.HotelService;

@Service
public class HotelServiceImpl implements HotelService{
    
	@Autowired
	private HotelRepo hotelRepo;
	
	@Override
	public Hotel create(Hotel hotel) {
		return hotelRepo.save(hotel);
	}

	@Override
	public List<Hotel> getAllHotel() {
		return hotelRepo.findAll();
	}

	@Override
	public Hotel getById(Integer hotelId) {
		return hotelRepo.findById(hotelId).orElseThrow(()->  new ResourceNotFound("Hotel not found with id " + hotelId));
	}

}
