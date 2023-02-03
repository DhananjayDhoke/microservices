package com.ServiceRegistry.SeerviceRegistry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SeerviceRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(SeerviceRegistryApplication.class, args);
	}

}
