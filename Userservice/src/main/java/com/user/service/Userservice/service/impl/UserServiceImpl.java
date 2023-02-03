package com.user.service.Userservice.service.impl;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.user.service.Userservice.entity.Hotel;
import com.user.service.Userservice.entity.Rating;
import com.user.service.Userservice.entity.User;
import com.user.service.Userservice.exception.ResourceNotFound;
import com.user.service.Userservice.externalServices.HotelService;
import com.user.service.Userservice.repo.UserRepo;
import com.user.service.Userservice.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private HotelService hotelService;

	@Override
	public User create(User user) {
		return userRepo.save(user);
	}

	@Override
	public List<User> getAllUser() {
		return userRepo.findAll();
	}

	@Override
	public User getUserById(Integer userId) {

		User user = userRepo
				.findById(userId)
				.orElseThrow(()-> new ResourceNotFound("User Not Found with Id" + userId));

		// here fetch rating of the above user from the rating service
		//http://localhost:8090/api/v1/rating/user/2

		Rating[] ratingsOfUser = restTemplate.getForObject("http://RATING-SERVICE/api/v1/rating/user/"+user.getUserId(), Rating[].class);
         
		List<Rating> list = Arrays.stream(ratingsOfUser).toList();
		List<Rating> ratingList = list.stream().map(rating->{
			// api call to hotel service to get the hotel
			//http://localhost:8089/api/v1/hotel/2

			//ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTEL-SERVICE/api/v1/hotel/"+rating.getHotelId(), Hotel.class);

			//Hotel body = forEntity.getBody();
			
			Hotel body = hotelService.hotel(rating.getHotelId());

			rating.setHotel(body);

			return rating;

		}).collect(Collectors.toList());

		user.setRatings(ratingList);
		return user;
	}

}
