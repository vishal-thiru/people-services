package com.java.People.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.java.People.model.People;
import com.java.People.service.PeopleService;
import com.java.People.service.dto.PeopleDTO;

import lombok.Setter;

@RestController
@Setter
public class PeopleController {

	@Autowired
	PeopleService pplService;

	@PostMapping(value = "/addContact", produces = {"application/json"}, consumes = {"application/json"})
	public ResponseEntity<People> addcontact(@RequestBody PeopleDTO ppl) {
		People response = pplService.save(ppl);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
