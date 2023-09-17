package com.javalabs.userfilemanager.service;

import java.util.List;
import java.util.Optional;

import com.javalabs.userfilemanager.domain.Person;
import com.javalabs.userfilemanager.exception.PersonAuthenticationException;

/**
 * Person Service Interface
 * Services related to Person
 * 
 * @author Alexandre Tavares - JavaLabs
 * @since Sep 2023
 * 
 */
public interface PersonService {

	void register(Person person);
	Person login(Person person) throws PersonAuthenticationException;
	Optional<Person> retrieve(Long id);
	Person update(Person person);
	void delete(Long id);
	List<Person> findAll();
}
