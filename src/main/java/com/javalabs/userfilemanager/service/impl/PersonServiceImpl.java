package com.javalabs.userfilemanager.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javalabs.userfilemanager.domain.File;
import com.javalabs.userfilemanager.domain.Person;
import com.javalabs.userfilemanager.repository.PersonRepository;
import com.javalabs.userfilemanager.service.PersonService;

import lombok.extern.slf4j.Slf4j;

/**
 * Person Service Implementation
 * Service implementation related to Person
 * 
 * @author Alexandre Tavares - JavaLabs
 * @since Sep 2023
 * 
 */
@Slf4j
@Service
public class PersonServiceImpl extends BaseServiceImpl implements PersonService  {

	@Autowired
	PersonRepository personRepository;
	
	@Override
	public void add(Person person) {
		personRepository.save(person);		
	}

	@Override
	public Optional<Person> retrieve(Long id) {
		return personRepository.findById(id);
	}

	@Override
	public void update(Person person) {
		personRepository.save(person);		
	}

	@Override
	public void delete(Long id) {
		Optional<Person> foundPerson = personRepository.findById(id);
		if (foundPerson.isPresent()) {
			personRepository.delete(foundPerson.get());
		}	
	}

}
