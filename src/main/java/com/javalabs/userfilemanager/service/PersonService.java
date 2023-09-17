package com.javalabs.userfilemanager.service;

import java.util.List;
import java.util.Optional;

import com.javalabs.userfilemanager.domain.Person;

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
	Optional<Person> retrieve(Long id);
	void update(Person person);
	void delete(Long id);
	List<Person> findAll();
}
