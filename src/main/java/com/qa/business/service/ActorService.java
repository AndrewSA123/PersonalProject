package com.qa.business.service;

import javax.inject.Inject;

import com.qa.persistence.domain.Actor;
import com.qa.persistence.repository.ActorRepo;

public class ActorService implements IActorService{

	@Inject
	ActorRepo repo;
	
	@Override
	public String createActor(String actor) {
		return repo.createActor(actor);
	}

	@Override
	public Actor findActor(Long id) {
		return repo.findActor(id);
	}

	@Override
	public String getAllActor() {
		// TODO Auto-generated method stub
		return repo.getAllActors();
	}

	@Override
	public String deleteActor(Long id) {
		// TODO Auto-generated method stub
		return repo.DeleteActor(id);
	}

	@Override
	public String updateActor(String actor, Long id) {
		// TODO Auto-generated method stub
		return repo.updateActor(id, actor);
	}

}
