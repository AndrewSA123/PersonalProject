package com.qa.business.service;

import com.qa.persistence.domain.Genre;
import com.qa.persistence.domain.Movie;

public interface IGenreService {
	
	String createGenre(String genre);

	Genre findGenre(Long id);

	String getAllGenre();

	String deleteGenre(Long id);

	String updateGenre(String genre, Long id);

}
