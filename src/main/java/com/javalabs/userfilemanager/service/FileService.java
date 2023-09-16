package com.javalabs.userfilemanager.service;

import java.util.Optional;

import com.javalabs.userfilemanager.domain.File;

/**
 * File Service Interface
 * Services related to File
 * 
 * @author Alexandre Tavares - JavaLabs
 * @since Sep 2023
 * 
 */
public interface FileService {
	
	public void add(File file);
	public Optional<File> retrieve(Long id);
	public void update(File file);
	public void delete(Long id);

}
