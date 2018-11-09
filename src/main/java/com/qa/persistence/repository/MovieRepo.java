package com.qa.persistence.repository;

import javax.transaction.Transactional;

import com.qa.persistence.domain.Movie;
import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.qa.util.JSONUtil;

@Transactional(SUPPORTS)
@Default
public class MovieRepo implements IMovieRepo {
	
	@PersistenceContext(unitName = "primary")
	private EntityManager em;
	
	@Inject
	private JSONUtil util;

	@Override
	@Transactional(REQUIRED)
	public String createMovie(String movie) {
		
		Movie m = util.getObjectForJSON(movie, Movie.class);
		em.persist(m);
		
		return "{\"message\": \"Movie Successfully Added\"}";
	}

	@Override
	public Movie findMovie(Long id) {
		
		return em.find(Movie.class, id);
	}

	@Override
	public String getAllMovies() {
		Query q = em.createQuery("Select a FROM Movies a");
		Collection<Movie> movies = (Collection<Movie>) q.getResultList();
		return util.getJSONForObject(movies);
	}

	@Override
	@Transactional(REQUIRED)
	public String DeleteMovie(Long id) {
		if(em.find(Movie.class, id) != null) {
		em.remove(id);
		}
		return "{\"message\": \"Movie sucessfully deleted\"}";
	}

	@Override
	@Transactional(REQUIRED)
	public String updateMovie(Long id, String movie) {
		Movie newMovie = util.getObjectForJSON(movie, Movie.class);
		Movie oldMovie = em.find(Movie.class, id);
		
		oldMovie.setMid(newMovie.getMid());
		oldMovie.setMainActor(newMovie.getActor());
		oldMovie.setGenre(newMovie.getGenre());
		oldMovie.setTitle(newMovie.getTitle());
		oldMovie.setFk_did(newMovie.getFk_did());
		
		
		return "{\"message\": \"Movie sucessfully updated\"}";
	}

}
