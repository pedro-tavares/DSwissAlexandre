package com.javalabs.userfilemanager.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    protected Long id;

    /*
    @ManyToOne
    @JoinTable(
    	name = "files_person", 
    	joinColumns = @JoinColumn(name = "file_id", referencedColumnName = "id"), 
    	inverseJoinColumns = @JoinColumn(name = "person_id", referencedColumnName = "id")
    ) 
    */   
    private Long personId;
	private String name;
	private String description;
	@Column(name = "file_path")
	private String filePath;
	@Column(name = "last_updated")
	private Date lastUpdated;
	
	public File(Long id) {
		this.id = id;
	}
	
	@PrePersist
    private void prePersistFunction(){
		this.lastUpdated = new Date(System.currentTimeMillis());
	}
}
