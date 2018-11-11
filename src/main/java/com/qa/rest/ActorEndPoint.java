package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.business.service.IActorService;

@Path("/actor")
public class ActorEndPoint {
	
	@Inject
	private IActorService as;
	
	@Path("/getallactors")
	@GET
	@Produces({"application/json"})
	public String getAllActors() {
		return as.getAllActor();
	}
	
	@Path("/getactor/{id}")
	@GET
	@Produces({"application/json"})
	public String getAActor(@PathParam("id") Long id) {
		return as.findActor(id).toString();
	}
	
	@Path("/deleteactor/{id}")
	@DELETE
	@Produces({"application/json"})
	public String deleteActor(@PathParam("id") Long id) {
		return as.deleteActor(id);
	}

	@Path("/createactor")
	@POST
	@Produces("application/json")
	public String createActor(String actor) {
		return as.createActor(actor);
	}
	
	@Path("/updateactor/{id}")
	@PUT
	@Produces({"application/json"})
	public String updateActor(@PathParam("id") Long id, String actor) {
		return as.updateActor(actor, id);
	}
	
	
	public void setService(IActorService service) {
		this.as = service;
	}
	
	
	
}
