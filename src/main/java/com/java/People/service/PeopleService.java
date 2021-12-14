package com.java.People.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.People.model.People;
import com.java.People.repository.PeopleRepository;
import com.java.People.service.dto.PeopleDTO;

@Service
public class PeopleService {

	@Autowired
	PeopleRepository repo;

	public People save(PeopleDTO request) {
		People pep = mapData(new People(), request);
		return repo.save(pep);
	}

	private People mapData(People people, PeopleDTO request) {
		people.setDateOfBirth(request.getDateOfBirth());
		people.setFirstName(request.getFirstName());
		people.setLastName(request.getLastName());
		people.setPhoneNumber(request.getPhoneNumber());
		people.set_id(UUID.randomUUID().toString());
		return people;
	}

}
