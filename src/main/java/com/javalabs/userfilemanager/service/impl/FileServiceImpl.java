package com.javalabs.userfilemanager.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javalabs.userfilemanager.domain.File;
import com.javalabs.userfilemanager.repository.FileRepository;
import com.javalabs.userfilemanager.service.FileService;

import lombok.extern.slf4j.Slf4j;

/**
 * File Service Implementation
 * Services implementation related to File
 * 
 * @author Alexandre Tavares - JavaLabs
 * @since Sep 2023
 * 
 */
@Slf4j
@Service
public class FileServiceImpl extends BaseServiceImpl implements FileService  {

	@Autowired
	FileRepository fileRepository;

	@Override
	public void add(File file) {
		fileRepository.save(file);
	}

	@Override
	public Optional<File> retrieve(Long id) {
		return fileRepository.findById(id);
	}

	@Override
	public void update(File file) {
		fileRepository.save(file);
	}

	@Override
	public void delete(Long id) {
		Optional<File> foundFile = fileRepository.findById(id);
		if (foundFile.isPresent()) {
			fileRepository.delete(foundFile.get());
		}
	}

}
