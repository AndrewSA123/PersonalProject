package com.qa.rest;

import java.io.IOException;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

import com.qa.business.service.IMovieService;

@Provider
@Path("/movie")
public class MovieEndPoint implements ContainerResponseFilter{
	
	@Inject
	private IMovieService ms;
	
	@Path("/getallmovies")
	@GET
	@Produces({"application/json"})
	public String getAllMovies() {
		return ms.getAllMovies();
	}
	
	@Path("/getmovie/{id}")
	@GET
	@Produces({"application/json"})
	public String getAMovie(@PathParam("id") Long id) {
		return ms.findMovie(id).toString();
	}
	
	@Path("/deletemovie/{id}")
	@DELETE
	@Produces({"application/json"})
	public String deleteMovie(@PathParam("id") Long id) {
		return ms.deleteMovies(id);
	}

	@Path("/createmovie")
	@POST
	@Produces("application/json")
	public String createMovie(String movie) {
		return ms.createMovie(movie);
	}
	
	@Path("/updatemovie/{id}")
	@PUT
	@Produces({"application/json"})
	public String updateMovie(@PathParam("id") Long id, String movie) {
		return ms.updateMovies(movie, id);
	}
	
	
	public void setService(IMovieService service) {
		this.ms = service;
	}

	   @Override
	   public void filter(final ContainerRequestContext requestContext,
	                      final ContainerResponseContext cres) throws IOException {
	      cres.getHeaders().add("Access-Control-Allow-Origin", "*");
	      cres.getHeaders().add("Access-Control-Allow-Headers", "origin, content-type, accept, authorization");
	      cres.getHeaders().add("Access-Control-Allow-Credentials", "true");
	      cres.getHeaders().add("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD");
	      cres.getHeaders().add("Access-Control-Max-Age", "1209600");
	   }
	
	
	
}
