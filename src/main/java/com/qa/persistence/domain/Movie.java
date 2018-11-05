package com.qa.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Movie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long mid;
	@Column(length = 100)
	private String title;
	private long fk_did;
	@Column(length = 100)
	private String genre;
	@Column(length = 100)
	private String mainActor;

	public Movie() {

	}
	
	public String getActor() {
		return this.mainActor;
	}
	
	public void setMainActor(String actor) {
		this.mainActor = actor;
	}

	public Movie(String title, String genre) {
		this.title = title;
		this.genre = genre;
	}

	public Long getMid() {
		return this.mid;
	}

	public void setMid(Long id) {
		this.mid = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return this.title;
	}

	public String getGenre() {
		return this.genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	public void setFk_did(Long id) {
		this.fk_did = id;
	}
	
	public Long getFk_did() {
		return this.fk_did;
	}

}
