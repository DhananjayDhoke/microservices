package com.user.service.Userservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user.service.Userservice.entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {

}
