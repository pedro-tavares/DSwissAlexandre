package com.javalabs.userfilemanager.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.javalabs.userfilemanager.domain.File;
import com.javalabs.userfilemanager.domain.Person;
import com.javalabs.userfilemanager.exception.PersonAuthenticationException;
import com.javalabs.userfilemanager.exception.PersonEmailCannotBeNullException;
import com.javalabs.userfilemanager.exception.PersonExistsException;
import com.javalabs.userfilemanager.repository.PersonRepository;
import com.javalabs.userfilemanager.security.SecurityConstants;
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
public class PersonServiceImpl /*extends BaseServiceImpl*/ implements PersonService  {

	@Autowired
	PersonRepository personRepository;
	
	//TODO
	/* 
	@Autowired
	private RoleRepository roleRepository;
	*/
	
	@Bean
	private PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	public Person register(Person person) throws PersonEmailCannotBeNullException, PersonExistsException {
		log.info("register:{}", person.getEmail());

		if (person.getEmail() == null) {
			throw new PersonEmailCannotBeNullException("Person email cannot be null.");
		}
		if (emailExists(person.getEmail())) {
			throw new PersonExistsException("Account with email already exists for " + person.getEmail());
		}
		
	    //person.setRoles(Arrays.asList(roleRepository.findByName("ROLE_USER")));

		Person registeredPerson = this.update(person);
		log.info("registeredPerson:{}", registeredPerson);

		return registeredPerson;
	}

	@Override
	public Person login(Person person) throws PersonAuthenticationException {
		log.info("login:{}", person.getEmail());

		Person registeredPerson = findByEmail(person.getEmail());
		if (registeredPerson != null) {
			
			log.info("login registeredPerson:{}", registeredPerson.toString());
			
        	if (this.encoder().matches(person.getPassword(), registeredPerson.getPassword())) {
        		log.info("AUTHENTICATED:{}", person.getEmail());

        		return registeredPerson;
        	}
        } 
		log.info("AUTHENTICATE FAILED!:{}", person.getEmail());
		throw new PersonAuthenticationException("Person Authentication Failed for " + person.getEmail());
	}
	
	
	@Override
	public Optional<Person> retrieve(Long id) {
		return personRepository.findById(id);
	}

	@Override
	public Person update(Person person) {
		log.info("save:{}{}", person.isNew() ? "NEW " : "", person.toString());

		String password = person.isNew() ? SecurityConstants.DEFAULT_PASSWORD : person.getPassword();
		person.setPassword(encoder().encode(password));

		return personRepository.saveAndFlush(person);	
	}

	@Override
	public void delete(Long id) {
		Optional<Person> foundPerson = personRepository.findById(id);
		if (foundPerson.isPresent()) {
			personRepository.delete(foundPerson.get());
		}	
	}

	@Override
	public Optional<Person> findById(Long id) {
		return personRepository.findById(id);
	}

	@Override
	public Person findByEmail(String email) {
		return personRepository.findByEmail(email);
	}
	
	@Override
	public List<Person> findAll() {
		return personRepository.findAll();
	}

	private boolean emailExists(final String email) {
		return personRepository.findByEmail(email) != null;
	}

	@Override
	public List<File> findFilesByPerson(Long id) {
		// TODO Auto-generated method stub
		return null;
	}	
}
