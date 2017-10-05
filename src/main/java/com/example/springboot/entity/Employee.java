package com.example.springboot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


@Entity
@Table (name="EMPLOYEE")
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id")
	private long Id;
	
	@Column(name="firstname")
	private String fName;
	
	@Column(name="lastname")
	private String lName;
	
	@Column(name="email")
	private String email;
	
	public Employee(){
		
	}
	
	public long getId() {
		return Id;
	}
	
	public void setId(long id) {
		Id = id;
	}
	public String getfName() {
		return fName;
	}


	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	

}
