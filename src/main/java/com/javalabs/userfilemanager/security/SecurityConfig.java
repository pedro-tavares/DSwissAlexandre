package com.javalabs.userfilemanager.security;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Security Configuration 
 * 
 * JWT
 * Includes JWT Authentication and Authorization
 * 
 * @author Alexandre Tavares - JavaLabs
 * @since Feb 2021
 * 
 */
@SuppressWarnings("deprecation")
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
 
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		/*
		.cors()
		.and()
		*/
		.csrf().disable()
		.authorizeRequests()
		.antMatchers(HttpMethod.GET, "/**").permitAll()
		.antMatchers(HttpMethod.POST, "/**").permitAll();
		//.antMatchers(HttpMethod.OPTIONS, "/**").permitAll();
/*
		http
			.cors()
			.and()
			.csrf().disable()
			.authorizeRequests()
			.antMatchers(HttpMethod.GET, "*").permitAll()
			.antMatchers(HttpMethod.POST, SecurityConstants.REGISTER_URL).permitAll()
			.anyRequest()
            .authenticated()
            .and()
            .addFilter(new JWTAuthenticationFilter(authenticationManager()))
            .addFilter(new JWTAuthorizationFilter(authenticationManager()))
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
*/
	}

}
