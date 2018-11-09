package com.qa.persistence.repository;

import com.qa.persistence.domain.Movie;

public interface IMovieRepo {
	
	String createMovie(String movie);
	
	Movie findMovie(Long id);
	
	String getAllMovies();
	
	String DeleteMovie(Long id);
	
	String updateMovie(Long id, String movie);

}
