package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.business.service.IGenreService;

@Path("/genre")
public class GenreEndPoint {
	
	@Inject
	private IGenreService gs;
	
	@Path("/getallgenres")
	@GET
	@Produces({"application/json"})
	public String getAllGenre() {
		return gs.getAllGenre();
	}
	
	@Path("/getgenre/{id}")
	@GET
	@Produces({"application/json"})
	public String getAGenre(@PathParam("id") Long id) {
		return gs.findGenre(id).toString();
	}
	
	@Path("/deletegenre/{id}")
	@DELETE
	@Produces({"application/json"})
	public String deleteGenre(@PathParam("id") Long id) {
		return gs.deleteGenre(id);
	}

	@Path("/creategenre")
	@POST
	@Produces("application/json")
	public String createGenre(String genre) {
		return gs.createGenre(genre);
	}
	
	@Path("/updategenre/{id}")
	@PUT
	@Produces({"application/json"})
	public String updateGenre(@PathParam("id") Long id, String genre) {
		return gs.updateGenre(genre, id);
	}
	
	
	public void setService(IGenreService service) {
		this.gs = service;
	}
	
	
	
}
