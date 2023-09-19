package com.javalabs.userfilemanager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.javalabs.userfilemanager.domain.File;

/**
 * File Repository
 * 
 * @author Alexandre Tavares - JavaLabs
 * @since Sep 2023
 * 
 */
public interface FileRepository extends JpaRepository<File, Long> {
	
	@Query("SELECT f FROM File f WHERE f.name = :filenameToFind")
    File findByName(String filenameToFind);

	@Query("SELECT f FROM File f WHERE f.personId = :personIdToFind")
	List<File> findByPerson(Long personId);
}