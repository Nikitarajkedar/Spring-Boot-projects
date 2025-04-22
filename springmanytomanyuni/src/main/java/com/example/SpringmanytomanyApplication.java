package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringmanytomanyApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringmanytomanyApplication.class, args);
		System.out.println("many to many mapping....");
	}

}
