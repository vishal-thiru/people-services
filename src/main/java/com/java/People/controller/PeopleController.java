package com.java.People.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.java.People.model.People;
import com.java.People.service.PeopleService;
import com.java.People.service.dto.PeopleDTO;
import com.java.People.service.exception.DataExistException;
import com.java.People.service.exception.DataNotFoundException;

import lombok.Setter;

@RestController
@Setter
public class PeopleController {

	@Autowired
	private PeopleService pplService;

	@PostMapping(value = "/contact", produces = { "application/json" }, consumes = { "application/json" })
	public ResponseEntity<People> addcontact(@RequestBody PeopleDTO ppl) throws DataExistException {
		People response = pplService.save(ppl);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PutMapping(value = "/contact", produces = { "application/json" }, consumes = { "application/json" })
	public ResponseEntity<People> updatecontact(@RequestBody PeopleDTO ppl) throws DataNotFoundException {
		People response = pplService.update(ppl);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping(value = "/getAllContact", produces = { "application/json" })
	public ResponseEntity<List<People>> updatecontact() throws DataExistException {
		List<People> response = pplService.getAllPeople();
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
