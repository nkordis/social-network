package com.socialnetwork.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.socialnetwork.model.validation.PasswordMatch;

@Entity
@Table(name = "users")
@PasswordMatch(message="{error.password.mismatch}")
public class SiteUser {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@Column(name = "email", unique=true)
	@Email(message = "{register.email.invalid}")
	@NotBlank(message = "{register.email.invalid}")
	private String email;

	@Transient  // it is not going to be saved in the db
	@Size(min=5, max=20, message="{register.password.size}")
	private String plainPassword;
	
	@Column(name = "password", length=60)
	private String password;
	
	@Column(name = "firstname", length=20)
	@Size(min=2, max=20, message="{register.firstname.size}")
	private String firstname;
	
	@Column(name = "surname", length=25)
	@Size(min=2, max=25, message="{register.surname.size}")
	private String surname;
	
	@Transient
	private String repeatPassword;
	
	@Column(name="enabled")
	private Boolean enabled = false;
	
	@Column(name="role", length=20)
	private String role;

	public SiteUser(){
		
	}
	// created for testing 
	public SiteUser(String email, String password){
		this.email = email;
		this.plainPassword = password;
		this.repeatPassword = password;
		this.enabled = true; // for testing
	}
	
	
	
	public SiteUser(String email, String password, String firstname, String surname) {
		super();
		this.email = email;
		this.password = password;
		this.firstname = firstname;
		this.surname = surname;
	}
	public Long getId() {
		return id;
	}

	
	public void setId(Long id) {
		this.id = id;
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

	
	public String getRole() {
		return role;
	}

	
	public void setRole(String role) {
		this.role = role;
	}

	
	public String getPlainPassword() {
		return plainPassword;
	}

	
	public void setPlainPassword(String plainPassword) {
		this.password = new BCryptPasswordEncoder().encode(plainPassword);
		this.plainPassword = plainPassword;
	}

	
	public String getRepeatPassword() {
		return repeatPassword;
	}

	
	public void setRepeatPassword(String repeatpassword) {
		this.repeatPassword = repeatpassword;
	}

	
	public Boolean getEnabled() {
		return enabled;
	}

	
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	
}
