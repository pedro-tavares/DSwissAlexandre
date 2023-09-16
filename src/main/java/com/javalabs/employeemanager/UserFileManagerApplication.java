package com.javalabs.employeemanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import lombok.extern.slf4j.Slf4j;

/**
 * User File Manager Application
 * 
 * @author Alexandre Tavares - JavaLabs
 * @since Sep 2023
 * 
 */
@Slf4j
@SpringBootApplication
public class UserFileManagerApplication {

	public static void main(String[] args) {
		log.info("JavaLabs - User and File Manager - v0.0.1");
		log.info("user.home @ {}", System.getProperty("user.home"));
		log.info("user.dir @ {}", System.getProperty("user.dir"));
		
		ApplicationContext applicationContext = SpringApplication.run(UserFileManagerApplication.class, args);
		
		// Debug Loaded Beans in Context
		for (String name: applicationContext.getBeanDefinitionNames()) {
			log.debug(name);
		}		
	}
}