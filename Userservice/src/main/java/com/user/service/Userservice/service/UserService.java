package com.user.service.Userservice.service;

import java.util.List;

import com.user.service.Userservice.entity.User;

public interface UserService {
   
	User create (User user);
	
	List<User> getAllUser ();
	
	User getUserById (Integer userId);
	
}
