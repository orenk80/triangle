package com.orenk.triangle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TriangleApplication {

	public static void main(String[] args) {
		SpringApplication.run(TriangleApplication.class, args);
	}
}
