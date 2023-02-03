package com.user.service.Userservice.exception;

import java.time.LocalDateTime;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class CustomizeErrorDetails {
	private LocalDateTime timeStamp;
	private String message;
	private String details;
}
