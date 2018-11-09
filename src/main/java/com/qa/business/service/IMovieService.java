package com.qa.business.service;

import com.qa.persistence.domain.Movie;

public interface IMovieService {
	
	String createMovie(String movie);

	Movie findMovie(Long id);

	String getAllMovies();

	String deleteMovies(Long id);

	String updateMovies(String movie, Long id);

}
