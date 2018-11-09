package com.qa.persistence.repository;

import com.qa.persistence.domain.Actor;
import com.qa.persistence.domain.Movie;

public interface IActorRepo {
	
	String createActor(String actor);
	
	Actor findActor(Long id);
	
	String getAllActors();
	
	String DeleteActor(Long id);
	
	String updateActor(Long id, String Actor);

}
