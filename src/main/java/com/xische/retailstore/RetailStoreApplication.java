package com.xische.retailstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The RetailStoreApplication class serves as the entry point for the Spring
 * Boot application. It contains the main method which is used to launch the
 * application.
 * 
 * @author shanmugamr
 */
@SpringBootApplication
public class RetailStoreApplication {

	/**
	 * The main method which serves as the entry point for the Spring Boot
	 * application.
	 * 
	 * @param args command-line arguments passed to the application.
	 */
	public static void main(String[] args) {
		SpringApplication.run(RetailStoreApplication.class, args);
	}
}
