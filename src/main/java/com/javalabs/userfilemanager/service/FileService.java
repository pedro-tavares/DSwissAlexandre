package com.javalabs.userfilemanager.service;

import java.util.List;
import java.util.Optional;

import com.javalabs.userfilemanager.domain.File;
import com.javalabs.userfilemanager.domain.Person;

/**
 * File Service Interface
 * Services related to File
 * 
 * @author Alexandre Tavares - JavaLabs
 * @since Sep 2023
 * 
 */
public interface FileService {
	
	void add(File file);
	Optional<File> retrieve(Long id);
	void update(File file);
	void delete(Long id);
	Optional<File> findById(Long id);	
	List<File> findAll();
}
