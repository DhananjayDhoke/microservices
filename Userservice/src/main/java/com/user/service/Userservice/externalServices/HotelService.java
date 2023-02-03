package com.user.service.Userservice.externalServices;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.user.service.Userservice.entity.Hotel;

@FeignClient(name = "HOTEL-SERVICE")
public interface HotelService {
   
	@GetMapping("/api/v1/hotel/{id}")
	Hotel hotel (@PathVariable Integer id);
}
