package com.benkner.todo.user;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(length = 30, nullable=false)
	private String firstName = "";
	@Column(length = 30, nullable=false)
	private String lastName = "";
	@Column(length = 30, nullable=false)
	private String username = "";
	@Column(length = 100, nullable=false)
	private String email = "";
	@JsonIgnore
	@Column(length = 60, nullable=false)
	private String password = "";
	@Column(columnDefinition="bit not null default 0")
	private boolean isAdmin = false;
	
	public User(){
	}
	public User(NewUserDTO newUserDTO, String password) {
		this.firstName = newUserDTO.firstName;
		this.lastName = newUserDTO.lastName;
		this.username = newUserDTO.username;
		this.email = newUserDTO.email;
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
	public boolean isAdmin() {
		return isAdmin;
	}
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	
	
}
