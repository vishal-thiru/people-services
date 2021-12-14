package com.java.People.repository;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.java.People.model.People;

@Repository
public interface PeopleRepository extends MongoRepository<People, UUID> {

}
