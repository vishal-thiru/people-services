package com.java.People.repository;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.java.People.model.People;

@Repository
public interface PeopleRepository extends MongoRepository<People, String> {
	
	@Query("{NAME: ?0, LAST_NAME: ?1, PH_NUMBER: ?2}")
	public People findPeople(String firstName, String lastName, String phNumber);
	
	@Query("{NAME: ?0, LAST_NAME: ?1, PEOPLE_ID: ?2}")
	public People findPeopleForUpdate(String firstName, String lastName, UUID phNumber);

//	@Query("{NAME:?0}")
	public People findByFirstName(String firstName);

}
