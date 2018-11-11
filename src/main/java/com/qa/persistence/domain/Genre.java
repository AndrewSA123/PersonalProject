package com.qa.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Genre {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long gid;
	@Column(length = 100)
	private String name;
	@OneToMany
	private Long mid;
	
	@Override
	public String toString() {
		return "{\"ID\": " + "\"" + this.mid + "\"" + "," + "\n\"Genre\": " + "\"" + this.name
				+ "\"" + "}";
	}
	
	public Genre() {
		
	}
	
	public Genre(String name, Long mid) {
		this.name = name;
		this.mid = mid;
	}
	
	public Long getGid() {
		return gid;
	}
	public void setGid(Long gid) {
		this.gid = gid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getMid() {
		return mid;
	}
	public void setMid(long mid) {
		this.mid = mid;
	}
	
	

}
