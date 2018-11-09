package com.qa.business.service;

import javax.inject.Inject;

import com.qa.persistence.domain.Movie;
import com.qa.persistence.repository.MovieRepo;

public class MovieService implements IMovieService{
	
	@Inject
	private MovieRepo repo;

	@Override
	public String createMovie(String movie) {
		return repo.createMovie(movie);
	}

	@Override
	public Movie findMovie(Long id) {
		return repo.findMovie(id);
	}

	@Override
	public String getAllMovies() {
		return repo.getAllMovies();
	}

	@Override
	public String deleteMovies(Long id) {
		return repo.DeleteMovie(id);
	}

	@Override
	public String updateMovies(String movie, Long id) {
		return repo.updateMovie(id, movie);
	}

}
