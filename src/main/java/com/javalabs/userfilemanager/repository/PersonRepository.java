package com.javalabs.userfilemanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.javalabs.userfilemanager.domain.Person;

/**
 * Person Repository
 * 
 * @author Alexandre Tavares - JavaLabs
 * @since Sep 2023
 * 
 */
public interface PersonRepository extends JpaRepository<Person, Long> {
	
	@Query("SELECT p FROM Person p WHERE p.username = :usernameToFind")
    Person findByUsername(String usernameToFind);
	
    @Query("SELECT p FROM Person p WHERE p.email = :emailToFind")
    Person findByEmail(String emailToFind);
    
}
