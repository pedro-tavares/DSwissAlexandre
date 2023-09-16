package com.javalabs.userfilemanager.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Base Controller
 * 
 * @author Alexandre Tavares - JavaLabs
 * @since Sep 2023
 * 
 */
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/")
public class BaseController implements ApplicationContextAware {

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {	
		log.info("{} is listening...", this.getClass().getSimpleName());
	}
	
    @GetMapping()
    Map<String, String> index(){
        Map<String, String> map = new HashMap<String, String>();
        map.put("title", "Home Page DSwiss User File Manager.");
        map.put("date", new Date().toString());
        return  map;
    }
}