package com.travelease;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@Configurable
public class TravelEaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(TravelEaseApplication.class, args);
	}

}
