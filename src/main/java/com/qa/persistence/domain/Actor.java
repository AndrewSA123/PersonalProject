package com.qa.persistence.domain;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Actor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long aid;
	@Column(length = 100)
	private String name;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "mid")
	private Set<Movie> movies;
	@Column(length = 100)
	private String age;
	
	@Override
	public String toString() {
		return "{\"ID\": " + "\"" + this.aid + "\"" + "," + "\n\"Name\": " + "\"" + this.name
				+ "\"" + "," + "\"" + "Age\":" + "\"" + this.age + "\"" + "}";
	}
	
	public Actor() {
		
	}
	
	public Actor(String name, Movie mid, String age) {
		this.name = name;
		this.movies.add(mid);
		this.age = age;
	}
	
	public Long getAid() {
		return aid;
	}
	public void setAid(Long aid) {
		this.aid = aid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set getMid() {
		return this.movies;
	}
	public void setMid(Movie mid) {
		this.movies.add(mid);
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}

}
