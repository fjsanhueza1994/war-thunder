package com.example.ms_aircrafts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.example.ms_commons.models.entity")
public class MsAircraftsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsAircraftsApplication.class, args);
	}

}
