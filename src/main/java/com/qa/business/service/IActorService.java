package com.qa.business.service;

import com.qa.persistence.domain.Actor;
import com.qa.persistence.domain.Movie;

public interface IActorService {
	
	String createActor(String actor);

	Actor findActor(Long id);

	String getAllActor();

	String deleteActor(Long id);

	String updateActor(String actor, Long id);

}
