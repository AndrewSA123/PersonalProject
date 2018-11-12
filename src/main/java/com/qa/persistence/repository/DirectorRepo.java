package com.qa.persistence.repository;

import javax.transaction.Transactional;

import com.qa.persistence.domain.Director;
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
public class DirectorRepo implements IDirectorRepo {
	
	@PersistenceContext(unitName = "primary")
	private EntityManager em;
	
	@Inject
	private JSONUtil util;

	@Override
	@Transactional(REQUIRED)
	public String createDirector(String director) {
		
		Director m = util.fromJSON(director, Director.class);
		em.persist(m);
		
		return "{\"message\": \"Director Successfully Added\"}";
	}

	@Override
	public Director findDirector(Long id) {
		
		return em.find(Director.class, id);
	}

	@Override
	public String getAllDirectors() {
		Query q = em.createQuery("Select a FROM Director a");
		Collection<Director> directors = (Collection<Director>) q.getResultList();
		return util.toJSON(directors);
	}

	@Override
	@Transactional(REQUIRED)
	public String deleteDirector(Long id) {
		if(em.find(Director.class, id) != null) {
		em.remove(id);
		}
		return "{\"message\": \"Director sucessfully deleted\"}";
	}

	@Override
	@Transactional(REQUIRED)
	public String updateDirector(Long id, String director) {
		Director newDirector = util.fromJSON(director, Director.class);
		Director oldDirector = em.find(Director.class, id);
		
		oldDirector.setAge(newDirector.getAge());
		oldDirector.setMid(newDirector.getMid());
		oldDirector.setName(newDirector.getName());

		return "{\"message\": \"Director sucessfully updated\"}";
	}

}
