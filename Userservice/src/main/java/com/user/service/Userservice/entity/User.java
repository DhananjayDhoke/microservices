package com.user.service.Userservice.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="micro_user")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;

    @Column(name="Name",length = 20,nullable = false)
	private String name;
	
	private String email;
	
	private String about;
	
	@Transient // not connecting to database
	private List<Rating> ratings = new ArrayList<>();
	
}
