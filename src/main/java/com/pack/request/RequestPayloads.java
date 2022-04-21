package com.pack.request;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class RequestPayloads {
	@NotBlank(message = "Name Field Can't be Empty")
	private String name;
	private String mob;
	private LocalDate dob;
	private String gendar;
	@NotBlank(message = "Email Field Can't be Empty")
	@Email(message = "provide valid Email")
	private String email;
	@NotBlank(message = "Address Field Can't be Empty")
	private String address;
	
	
	public String getName() {
		return name;
	}
	public String getMob() {
		return mob;
	}
	public LocalDate getDob() {
		return dob;
	}
	public String getGendar() {
		return gendar;
	}
	public String getEmail() {
		return email;
	}
	public String getAddress() {
		return address;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void setMob(String mob) {
		this.mob = mob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public void setGendar(String gendar) {
		this.gendar = gendar;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
	
}
