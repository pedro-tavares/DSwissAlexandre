package com.javalabs.userfilemanager.service;

import java.util.List;
import java.util.Optional;

import com.javalabs.userfilemanager.domain.File;
import com.javalabs.userfilemanager.domain.Person;
import com.javalabs.userfilemanager.exception.PersonAuthenticationException;
import com.javalabs.userfilemanager.exception.PersonEmailCannotBeNullException;
import com.javalabs.userfilemanager.exception.PersonExistsException;

/**
 * Person Service Interface
 * Services related to Person
 * 
 * @author Alexandre Tavares - JavaLabs
 * @since Sep 2023
 * 
 */
public interface PersonService {

	Person register(Person person) throws PersonEmailCannotBeNullException, PersonExistsException;
	Person login(Person person) throws PersonAuthenticationException;
	Optional<Person> retrieve(Long id);
	Person update(Person person);
	void delete(Long id);
	Optional<Person> findById(Long id);
	Person findByEmail(String email);
	List<Person> findAll();
	List<File> findFilesByPerson(Long id);
}
