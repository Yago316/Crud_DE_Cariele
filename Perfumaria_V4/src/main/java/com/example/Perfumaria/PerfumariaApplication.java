package com.example.Perfumaria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.example.Perfumaria_Model")
public class PerfumariaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PerfumariaApplication.class, args);
	}

}
