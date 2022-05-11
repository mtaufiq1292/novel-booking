package com.shop.novelbooking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NovelBookingApplication {

	//run springboot in local
	//run command 
	// .\mvnw spring-boot:run

	//deploy to azure
	//run command 
	// mvn clean package azure-webapp:deploy
	public static void main(String[] args) {
		SpringApplication.run(NovelBookingApplication.class, args);
	}

}
