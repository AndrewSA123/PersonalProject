package com.qa.persistence.repository;

import javax.transaction.Transactional;

import com.qa.persistence.domain.Actor;
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
public class ActorRepo implements IActorRepo {
	
	@PersistenceContext(unitName = "primary")
	private EntityManager em;
	
	@Inject
	private JSONUtil util;

	@Override
	@Transactional(REQUIRED)
	public String createActor(String actor) {
		
		Actor m = util.fromJSON(actor, Actor.class);
		em.persist(m);
		
		return "{\"message\": \"Actor Successfully Added\"}";
	}

	@Override
	public Actor findActor(Long id) {
		
		return em.find(Actor.class, id);
	}

	@Override
	public String getAllActors() {
		Query q = em.createQuery("Select a FROM Directors a");
		Collection<Actor> actors = (Collection<Actor>) q.getResultList();
		return util.toJSON(actors);
	}

	@Override
	@Transactional(REQUIRED)
	public String DeleteActor(Long id) {
		if(em.find(Actor.class, id) != null) {
		em.remove(id);
		}
		return "{\"message\": \"Actor sucessfully deleted\"}";
	}

	@Override
	@Transactional(REQUIRED)
	public String updateActor(Long id, String actor) {
		Actor newActor = util.fromJSON(actor, Actor.class);
		Actor oldActor = em.find(Actor.class, id);
		
		oldActor.setAid(newActor.getAid());
		oldActor.setMid(newActor.getMid());
		oldActor.setAge(newActor.getAge());
		oldActor.setName(newActor.getName());
		
		
		
		return "{\"message\": \"Actor sucessfully updated\"}";
	}

}
