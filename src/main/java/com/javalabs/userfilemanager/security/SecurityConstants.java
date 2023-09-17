package com.javalabs.userfilemanager.security;

/**
 * Security Constants   
 *
 * @author Alexandre Tavares - JavaLabs
 * @since Feb 2021
 * 
 */
public class SecurityConstants {
	
	public static final String DEFAULT_PASSWORD = "password";
	public static final String SECRET = "SECRET_KEY";
	public static final long EXPIRATION_TIME = 900_000; // 15 mins
	public static final String TOKEN_PREFIX = "Bearer ";
	public static final String HEADER_STRING = "Authorization";
	public static final String REGISTER_URL = "/person/register";
	
}
