package com.teamSystem.usermanager.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;

@Entity
@Table(name = "users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "name", nullable = false)
	private String name;
	@Column(name = "surname", nullable = false)
	private String surname;
	@Column(name = "fiscalcode", unique=true)
	private String fiscalCode;
	
	public User() {}
	
	public User(String name, String surname, String fiscalCode) {
		super();
		this.name = name;
		this.surname = surname;
		this.fiscalCode = fiscalCode;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getFiscalCode() {
		return fiscalCode;
	}

	public void setFiscalCode(String fiscalCode) {
		this.fiscalCode = fiscalCode;
	}
	
	public boolean isValidUser() {
		return name != null && !name.equals("") && surname != null && 
				!surname.equals("") && fiscalCode != null && !fiscalCode.equals("") && id != null && !id.equals("");
	}
	
	public String toString() {
		return "[Id: " + id + ", name: " + name + ", surname: " + surname + ", fiscalCode: " + fiscalCode + "]" ;
	}
	
	
}
