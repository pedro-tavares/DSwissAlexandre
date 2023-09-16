package com.javalabs.userfilemanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.javalabs.userfilemanager.domain.File;
import com.javalabs.userfilemanager.domain.Person;

/**
 * File Repository
 * 
 * @author Alexandre Tavares - JavaLabs
 * @since Sep 2023
 * 
 */
public interface FileRepository extends JpaRepository<File, Long> {
	
	@Query("SELECT f FROM File f WHERE f.name = :filenameToFind")
    Person findByName(String filenameToFind);

}