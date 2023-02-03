package com.user.service.Userservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Hotel {
 
    private Integer hotelId;
	
	private String name;
	
	private String location;
	
	private String about;
}
