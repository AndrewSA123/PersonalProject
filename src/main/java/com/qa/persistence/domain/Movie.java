package com.qa.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


@Entity
public class Movie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long mid;
	@Column(length = 100)
	private String title;
	@ManyToOne
	private long did;
	@ManyToOne
	private Long gid;
	@Column(length = 100)
	private String mainActor;
	
	@Override
	public String toString() {
		return "{\"ID\": " + "\"" + this.mid + "\"" + "," + "\n\"Title\": " + "\"" + this.title
				+ "\"" + "," + "\"" + "Starring\":" + "\"" + this.mainActor + "\"" + "}";
	}

	public Movie() {

	}
	public Long getFK_Gid() {
		return gid;
	}

	public void setFk_Gid(Long gid) {
		this.gid = gid;
	}
	
	public String getActor() {
		return this.mainActor;
	}
	
	public void setMainActor(String actor) {
		this.mainActor = actor;
	}

	public Movie(String title, String MainActor, Long did, Long gid) {
		this.title = title;
		this.mainActor = MainActor;
		this.did = did;
		this.gid = gid;
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

	public Long getGenre() {
		return this.gid;
	}

	public void setGenre(Long genre) {
		this.gid = genre;
	}
	
	public void setFk_did(Long id) {
		this.did = id;
	}
	
	public Long getFk_did() {
		return this.did;
	}

}
