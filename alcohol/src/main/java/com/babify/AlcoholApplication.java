package com.babify;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication (exclude = SecurityAutoConfiguration.class)
public class AlcoholApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlcoholApplication.class, args);
	}

}
