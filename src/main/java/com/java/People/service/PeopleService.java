package com.java.People.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.People.model.People;
import com.java.People.repository.PeopleRepository;
import com.java.People.service.dto.PeopleDTO;
import com.java.People.service.exception.DataExistException;
import com.java.People.service.exception.DataNotFoundException;

@Service
public class PeopleService {

	@Autowired
	PeopleRepository repo;

	public People save(PeopleDTO request) throws DataExistException {

		People pep = mapData(new People(), request);
		People inDB = repo.findPeople(request.getFirstName(), request.getLastName(), request.getPhoneNumber());
		if (inDB != null) {
			throw new DataExistException();
		}
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

	public List<People> getAllPeople() {
		return repo.findAll();
	}

	public People update(PeopleDTO ppl) throws DataNotFoundException {
		People inDB = repo.findByFirstName(ppl.getFirstName());
		if (inDB == null) {
			throw new DataNotFoundException();
		}
		People pep = inDB;
		pep.setDateOfBirth(ppl.getDateOfBirth());
		pep.setLastName(ppl.getLastName());
		pep.setPhoneNumber(ppl.getPhoneNumber());
		return repo.save(pep);
	}

}
