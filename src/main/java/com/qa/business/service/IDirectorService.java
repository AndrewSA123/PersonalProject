package com.qa.business.service;

import com.qa.persistence.domain.Director;

public interface IDirectorService {
	
	String createDirector(String director);

	Director findDirector(Long id);

	String getAllDirector();

	String deleteDirector(Long id);

	String updateDirector(String director, Long id);

}
