package com.javalabs.userfilemanager;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;

import com.javalabs.userfilemanager.domain.File;
import com.javalabs.userfilemanager.repository.FileRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * File Service Tests
 * 
 * @author Alexandre Tavares - JavaLabs
 * @since Sep 2023
 * 
 */
@Slf4j
@SpringBootTest
public class FileServiceTests {

	@Autowired
	FileRepository fileRepository;
	
	@Test
	@Order(1)
	public void add() {
		File file = new File(1L);
		fileRepository.save(file);

		Optional<File> findFile = fileRepository.findById(1L);
		if (findFile.isEmpty()) {
			fail("File doesnt exist.");
		}
	}

	@Test
	@Order(2)
	public void retrieveAfterDelete(/*Long id*/) {
		File file = new File(1L);
		fileRepository.save(file);

		Optional<File> findFile = fileRepository.findById(1L);
		if (findFile.isEmpty()) {
			fail("File doesnt exist.");
		}
		
		fileRepository.delete(file);
		
		findFile = fileRepository.findById(1L);
		if (findFile.isPresent()) {
			fail("File still exists.");
		}		
	}

}
