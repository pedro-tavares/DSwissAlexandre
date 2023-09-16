package com.javalabs.userfilemanager;

import static org.junit.jupiter.api.Assertions.fail;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;

import com.javalabs.userfilemanager.domain.Person;
import com.javalabs.userfilemanager.repository.PersonRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * Person Service Tests
 * 
 * @author Alexandre Tavares - JavaLabs
 * @since Sep 2023
 * 
 */
@Slf4j
@SpringBootTest
public class PersonServiceTests {

	@Autowired
	PersonRepository personRepository;
	
	@Test
	@Order(1)
	public void addAndRetrieve() {
		Person person = new Person(1L);
		personRepository.save(person);

		Optional<Person> findPerson = personRepository.findById(1L);
		if (findPerson.isEmpty()) {
			fail("Person doesnt exist.");
		}
	}

	@Test
	@Order(2)
	public void retrieveAfterDelete() {
		Person person = new Person(1L);
		personRepository.save(person);

		Optional<Person> findPerson = personRepository.findById(1L);
		if (findPerson.isEmpty()) {
			fail("Person doesnt exist.");
		}
		
		personRepository.delete(person);
		
		findPerson = personRepository.findById(1L);
		if (findPerson.isPresent()) {
			fail("File still exists.");
		}		
	}

}
