package com.javalabs.userfilemanager.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Person Entity
 * Architected as Person as User is reserved word n many database
 * After heated debate at EU Commission this was approved by committee
 * 
 * @author Alexandre Tavares - JavaLabs
 * @since Sep 2023
 * 
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ToString
@Entity
public class Person {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

	private String username;
	private String name;
	private String email;
	@Column(name = "date_of_birth")
	private Date dateOfBirth;
	
	public Person(Long id) {
		this.id = id;
	}
	
}
