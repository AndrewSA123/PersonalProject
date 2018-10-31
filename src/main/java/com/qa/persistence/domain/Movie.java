package com.qa.persistence.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Movie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long mid;
	private String title;
	private long fk_did;
	private String genre;

	public Movie() {

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

}
