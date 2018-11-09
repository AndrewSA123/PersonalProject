package com.qa.business.service;

import javax.inject.Inject;

import com.qa.persistence.domain.Genre;
import com.qa.persistence.repository.GenreRepo;

public class GenreService implements IGenreService{

	@Inject
	GenreRepo repo;
	
	@Override
	public String createGenre(String genre) {
		return repo.createGenre(genre);
	}

	@Override
	public Genre findGenre(Long id) {
		return repo.findGenre(id);
	}

	@Override
	public String getAllGenre() {
		return repo.getAllGenres();
	}

	@Override
	public String deleteGenre(Long id) {
		return repo.deleteGenre(id);
	}

	@Override
	public String updateGenre(String genre, Long id) {
		return repo.updateGenre(id, genre);
	}

}
