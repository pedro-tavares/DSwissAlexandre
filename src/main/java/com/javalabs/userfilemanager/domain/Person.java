package com.javalabs.userfilemanager.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

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
public class Person implements UserDetails {
	
    private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    protected Long id;

	private String username;
	private String name;
	private String email;
	@Column(name = "date_of_birth")
	private Date dateOfBirth;
	private String password;
    @ManyToMany 
    @JoinTable( 
    	name = "person_roles", 
    	joinColumns = @JoinColumn( name = "person_id", referencedColumnName = "id"), 
        inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")) 
    private Collection<Role> roles;
    @OneToMany 
    @JoinTable( 
    	name = "person_files",  
    	joinColumns = @JoinColumn(name = "person_id", referencedColumnName = "id"), 
        inverseJoinColumns = @JoinColumn(name = "file_id", referencedColumnName = "id")) 
    private Collection<File> files;
    
	public Person(Long id) {
		this.id = id;
	}

    public boolean isNew() {
    	return this.id == null;
    }

    public boolean hasPassword() {
    	return (this.password != null && (!this.password.isBlank() || !password.isEmpty()));
    }
    
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> roles = new ArrayList<>();
        roles.add(new SimpleGrantedAuthority(this.roles.toString()));
        return roles;	
	}

	@Override
	public String getUsername() {
		return this.username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}	
}
