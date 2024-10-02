package com.example.ms_pilotaircraft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = {
		"com.example.ms_commons.models.entity",
		"com.example.ms_pilotaircraft.models.entity"
})
public class MsPilotaircraftApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsPilotaircraftApplication.class, args);
	}

}
