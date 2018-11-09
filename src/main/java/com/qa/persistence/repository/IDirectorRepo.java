package com.qa.persistence.repository;

import com.qa.persistence.domain.Director;
import com.qa.persistence.domain.Movie;

public interface IDirectorRepo {
	
	String createDirector(String director);
	
	Director findDirector(Long id);
	
	String getAllDirectors();
	
	String deleteDirector(Long id);
	
	String updateDirector(Long id, String director);

}
