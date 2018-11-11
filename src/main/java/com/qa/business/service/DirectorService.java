package com.qa.business.service;

import javax.inject.Inject;

import com.qa.persistence.domain.Director;
import com.qa.persistence.repository.DirectorRepo;

public class DirectorService implements IDirectorService{

	@Inject
	DirectorRepo repo;
	
	@Override
	public String createDirector(String director) {
		return repo.createDirector(director);
	}

	@Override
	public Director findDirector(Long id) {
		return repo.findDirector(id);
	}

	@Override
	public String getAllDirector() {
		return repo.getAllDirectors();
	}

	@Override
	public String deleteDirector(Long id) {
		return repo.deleteDirector(id);
	}

	@Override
	public String updateDirector(String director, Long id) {
		return repo.updateDirector(id, director);
	}

}
