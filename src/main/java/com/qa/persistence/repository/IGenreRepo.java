package com.qa.persistence.repository;

import com.qa.persistence.domain.Genre;
import com.qa.persistence.domain.Movie;

public interface IGenreRepo {
	
	String createGenre(String genre);
	
	Genre findGenre(Long id);
	
	String getAllGenres();
	
	String deleteGenre(Long id);
	
	String updateGenre(Long id, String genre);

}
