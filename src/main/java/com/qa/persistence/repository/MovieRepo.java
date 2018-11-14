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
		
		Movie m = util.fromJSON(movie, Movie.class);
		em.persist(m);
		
		return "{\"message\": \"Movie Successfully Added\"}";
	}

	@Override
	public Movie findMovie(Long id) {
		
		return em.find(Movie.class, id);
	}

	@Override
	public String getAllMovies() {
		Query q = em.createQuery("Select a FROM Movie a");
		Collection<Movie> movies = (Collection<Movie>) q.getResultList();
		return util.toJSON(movies);
	}

	@Override
	@Transactional(REQUIRED)
	public String DeleteMovie(Long id) {
		if(em.find(Movie.class, id) != null) {
		em.remove(em.find(Movie.class, id));
		}
		return "{\"message\": \"Movie sucessfully deleted\"}";
	}

	@Override
	@Transactional(REQUIRED)
	public String updateMovie(Long id, String movie) {
		Movie newMovie = util.fromJSON(movie, Movie.class);
		Movie oldMovie = em.find(Movie.class, id);
		
		oldMovie.setMid(newMovie.getMid());
		oldMovie.setTitle(newMovie.getTitle());
		
		
		return "{\"message\": \"Movie sucessfully updated\"}";
	}

}
