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

import com.javalabs.userfilemanager.domain.Person;
import com.javalabs.userfilemanager.exception.PersonAuthenticationException;
import com.javalabs.userfilemanager.exception.PersonEmailCannotBeNullException;
import com.javalabs.userfilemanager.exception.PersonExistsException;
import com.javalabs.userfilemanager.security.JWTTokenUtil;
import com.javalabs.userfilemanager.service.PersonService;

import lombok.extern.slf4j.Slf4j;

/**
 * Person Front Controller
 * 
 * @author Alexandre Tavares - JavaLabs
 * @since Sep 2023
 * 
 */
@Slf4j
@RestController
@RequestMapping("/person")
public class PersonController /*extends BaseController*/ {
	
	@Autowired
	private JWTTokenUtil jwtTokenUtil;
	
	@Autowired
	PersonService personService;
	
	/**
	 * Get all 
	 * 
	 */
    @GetMapping("/list")
    public ResponseEntity<List<Person>> list() {
		log.info("list");    	
    	return new ResponseEntity<List<Person>>((List<Person>) personService.findAll(), HttpStatus.OK);
    }

	/**
	 * Get by Person id 
	 * 
	 */    
    @GetMapping("/{id}")
    ResponseEntity<Person> personById(@PathVariable Long id) {
    	log.info("personById {}", id); 
    	return new ResponseEntity(personService.findById(id), HttpStatus.OK);
    }

	/**
	 * Get Files by Person id 
	 * 
	 */    
    @GetMapping("/{id}/files")
    ResponseEntity<Person> filesByPersonId(@PathVariable Long id) {
    	log.info("filesByPersonId {}", id); 
    	return new ResponseEntity(personService.findById(id), HttpStatus.OK);
    }
    
    /**
     * Person Register
     * 
     * @param person
     * @return registration outcome
     */
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody Person person) {
    	log.info("register:{}", person.getEmail());
 	
    	ResponseEntity<String> response = null;
        try {	
        	personService.register(person);

        	response = ResponseEntity.ok("DSwiss User Account Register: OK");
        	
		} catch (PersonEmailCannotBeNullException | PersonExistsException | Exception e) {
			response = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		} 
        return response;
    }    

    /**
     * Person login
     * 
     */
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Person person) {
    	log.info("login:{}", person.getEmail());
    	
    	ResponseEntity<String> response = null;
    	
        try {
			if (personService.login(person) != null) {
				final String token = jwtTokenUtil.generateToken(person);	
				response = ResponseEntity.ok(token);	
			} 
			
		} catch (PersonAuthenticationException e) {
			response = new ResponseEntity<String>("ERROR:" + e.getMessage(), HttpStatus.UNAUTHORIZED);
		}
        return response;
    }    

    /**
     * Save Person
     * 
     * @param person
     * @return service outcome
     */
    @PostMapping("/save")
    public ResponseEntity<Person> save(@RequestBody Person person) {
    	log.info("save:{}", person.toString());
    	
        return new ResponseEntity<Person>(personService.update(person), HttpStatus.OK);
    }    
 
}