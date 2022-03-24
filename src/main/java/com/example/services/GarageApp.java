package com.example.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GarageApp {
	private static final Logger log = LoggerFactory.getLogger(GarageApp.class);

	public static void main(String[] args) {
		log.info("Garage Aplication Starting...");
		SpringApplication.run(GarageApp.class, args);
	}

}
