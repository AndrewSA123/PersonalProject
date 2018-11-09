package com.qa.persistence.repository;

import javax.transaction.Transactional;

import com.qa.persistence.domain.Genre;
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
public class GenreRepo implements IGenreRepo {
	
	@PersistenceContext(unitName = "primary")
	private EntityManager em;
	
	@Inject
	private JSONUtil util;

	@Override
	@Transactional(REQUIRED)
	public String createGenre(String genre) {
		
		Genre m = util.getObjectForJSON(genre, Genre.class);
		em.persist(m);
		
		return "{\"message\": \"Genre Successfully Added\"}";
	}

	@Override
	public Genre findGenre(Long id) {
		
		return em.find(Genre.class, id);
	}

	@Override
	public String getAllGenres() {
		Query q = em.createQuery("Select a FROM Genres a");
		Collection<Genre> genres = (Collection<Genre>) q.getResultList();
		return util.getJSONForObject(genres);
	}

	@Override
	@Transactional(REQUIRED)
	public String deleteGenre(Long id) {
		if(em.find(Genre.class, id) != null) {
		em.remove(id);
		}
		return "{\"message\": \"Genre sucessfully deleted\"}";
	}

	@Override
	@Transactional(REQUIRED)
	public String updateGenre(Long id, String genre) {
		Genre newGenre = util.getObjectForJSON(genre, Genre.class);
		Genre oldGenre = em.find(Genre.class, id);
		
		oldGenre.setMid(newGenre.getMid());
		oldGenre.setName(newGenre.getName());
		
		
		
		return "{\"message\": \"Genre sucessfully updated\"}";
	}

}
