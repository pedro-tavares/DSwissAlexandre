package com.javalabs.userfilemanager.service;

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

	public void add(Person person);
	public Optional<Person> retrieve(Long id);
	public void update(Person person);
	public void delete(Long id);
}
