package com.javalabs.userfilemanager.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javalabs.userfilemanager.domain.Person;
import com.javalabs.userfilemanager.exception.PersonAuthenticationException;
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
	public void register(Person person) {
		personRepository.save(person);		
	}

	@Override
	public Person login(Person person) throws PersonAuthenticationException {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Optional<Person> retrieve(Long id) {
		return personRepository.findById(id);
	}

	@Override
	public Person update(Person person) {
		return personRepository.save(person);		
	}

	@Override
	public void delete(Long id) {
		Optional<Person> foundPerson = personRepository.findById(id);
		if (foundPerson.isPresent()) {
			personRepository.delete(foundPerson.get());
		}	
	}

	@Override
	public List<Person> findAll() {
		return personRepository.findAll();
	}

}
