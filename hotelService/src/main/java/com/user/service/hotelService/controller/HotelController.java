package com.user.service.hotelService.controller;

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


import com.user.service.hotelService.entity.Hotel;
import com.user.service.hotelService.service.HotelService;

@RestController
@RequestMapping("/api/v1/hotel")
public class HotelController {
  
	@Autowired
	private HotelService hotelService;
	
	@PostMapping
	public ResponseEntity<Hotel> createHotelHandler(@RequestBody Hotel hotel){
		
		Hotel createdHotel = hotelService.create(hotel);
		
		return new ResponseEntity<>(createdHotel,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Hotel> getHoteHandler (@PathVariable Integer id){
		
	  Hotel getHotelById = hotelService.getById(id);
		
		return new ResponseEntity<>(getHotelById, HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity< List<Hotel>> getAllHotelHandler (){
		
	   List<Hotel> allHotel = hotelService.getAllHotel();
		
		return new ResponseEntity<>(allHotel, HttpStatus.OK);
	}
	
}
