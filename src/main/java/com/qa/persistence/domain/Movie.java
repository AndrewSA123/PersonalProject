package com.qa.persistence.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
	@JoinColumn(name = "aid")
	private Actor aid;
	@ManyToOne
	@JoinColumn(name = "gid")
	private Genre gid;
	@ManyToOne
	@JoinColumn(name = "did")
	private Director did;
	@Override
	public String toString() {
		return "{\"ID\": " + "\"" + this.mid + "\"" + "," + "\n\"Title\": " + "\"" + this.title
				+ "\"" + "," + "\"" + "}";
	}

	public Movie() {

	}
	
	public Movie(String title, Actor aid, Genre gid, Director did) {
		this.title = title;
		this.aid = aid;
		this.gid = gid;
		this.did = did;

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
	
	public String getDid() {
		return this.did.toString();
	}
	
	public String getGid() {
		return this.gid.toString();
	}
	public String getAid() {
		return this.aid.toString();
	}


}
