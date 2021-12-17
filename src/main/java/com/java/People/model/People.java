package com.java.People.model;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "PEOPLE")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class People implements Serializable {

	private static final long serialVersionUID = 1L;

//	@Id
//	UUID peopleID;
	
	@Field("_id")
	String _id;

	@Field("NAME")
	String firstName;

	@Field("LAST_NAME")
	String lastName;

	@Field("PH_NUMBER")
	String phoneNumber;

	@Field("DOB")
	String dateOfBirth;

}
