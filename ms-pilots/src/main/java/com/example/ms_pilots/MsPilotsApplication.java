package com.example.ms_pilots;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@EntityScan(basePackages = "com.example.ms_commons.models.entity")
public class MsPilotsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsPilotsApplication.class, args);
	}

}
