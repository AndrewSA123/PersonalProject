package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.business.service.IDirectorService;

@Path("/director")
public class DirectorEndPoint {
	
	@Inject
	private IDirectorService ds;
	
	@Path("/getalldirectors")
	@GET
	@Produces({"application/json"})
	public String getAllDirectors() {
		return ds.getAllDirector();
	}
	
	@Path("/getdirector/{id}")
	@GET
	@Produces({"application/json"})
	public String getADirector(@PathParam("id") Long id) {
		return ds.findDirector(id).toString();
	}
	
	@Path("/deletedirector/{id}")
	@DELETE
	@Produces({"application/json"})
	public String deleteDirector(@PathParam("id") Long id) {
		return ds.deleteDirector(id);
	}

	@Path("/createdirector")
	@POST
	@Produces("application/json")
	public String createDirector(String director) {
		return ds.createDirector(director);
	}
	
	@Path("/updatedirector/{id}")
	@PUT
	@Produces({"application/json"})
	public String updateDirector(@PathParam("id") Long id, String director) {
		return ds.updateDirector(director, id);
	}
	
	
	public void setService(IDirectorService service) {
		this.ds = service;
	}
	
	
	
}
