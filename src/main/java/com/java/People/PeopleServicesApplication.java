package com.java.People;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class PeopleServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(PeopleServicesApplication.class, args);
	}

}
