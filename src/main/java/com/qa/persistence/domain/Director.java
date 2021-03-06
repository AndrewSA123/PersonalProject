package com.qa.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Director {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long did;
	@Column(length = 100)
	private String name;
	@Column(length = 100)
	private String age;

	
	
	@Override
	public String toString() {
		return "{\"ID\": " + "\"" + this.did + "\"" + "," + "\n\"Name\": " + "\"" + this.name
				+ "\"" + "," + "\"" + "Age\":" + "\"" + this.age + "\"" + "}";
	}
	
	public Director() {
		
	}
	
	public Director(String name, String age) {
		this.name = name;
		this.age = age;
	}
	
	
	public Long getDid() {
		return did;
	}

	public void setDid(Long did) {
		this.did = did;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	

}
