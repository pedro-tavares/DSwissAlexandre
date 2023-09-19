package com.javalabs.userfilemanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javalabs.userfilemanager.domain.File;
import com.javalabs.userfilemanager.domain.Person;
import com.javalabs.userfilemanager.exception.PersonAuthenticationException;
import com.javalabs.userfilemanager.exception.PersonEmailCannotBeNullException;
import com.javalabs.userfilemanager.exception.PersonExistsException;
import com.javalabs.userfilemanager.service.FileService;

import lombok.extern.slf4j.Slf4j;

/**
 * File Front Controller
 * 
 * @author Alexandre Tavares - JavaLabs
 * @since Sep 2023
 * 
 */
@Slf4j
@RestController
@RequestMapping("/file")
public class FileController extends BaseController {
	
	@Autowired
	FileService fileService;
	
	/**
	 * Get all 
	 * 
	 */
    @GetMapping("/list")
    public ResponseEntity<List<File>> list() {
		log.info("list");    	
    	return new ResponseEntity<List<File>>((List<File>) fileService.findAll(), HttpStatus.OK);
    }

	/**
	 * Get by id 
	 * 
	 */       
    @GetMapping("/{id}")
    ResponseEntity<File> fileById(@PathVariable Long id) {
    	log.info("fileById {}", id); 
    	return new ResponseEntity(fileService.findById(id), HttpStatus.OK);
    }

}