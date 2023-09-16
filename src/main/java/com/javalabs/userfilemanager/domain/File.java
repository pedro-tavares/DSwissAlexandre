package com.javalabs.userfilemanager.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * File Entity
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
public class File {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    private Long userId;
	private String name;
	private String description;
	@Column(name = "file_path")
	private String filePath;
	@Column(name = "last_updated")
	private Date lastUpdated;
	
	public File() {}

	public File(Long id) {
		this.id = id;
	}
	
	@PrePersist
    private void prePersistFunction(){
		this.lastUpdated = new Date(System.currentTimeMillis());
	}
}
