package com.java.People.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PeopleDTO {

	String firstName;

	String lastName;

	String phoneNumber;
	
	String dateOfBirth; 

}
