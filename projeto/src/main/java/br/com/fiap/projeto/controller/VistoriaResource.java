package br.com.fiap.projeto.controller;

import java.io.IOException;
import java.util.ArrayList;

import br.com.fiap.projeto.model.entity.Vistoria;
import br.com.fiap.projeto.model.repository.VistoriaRepository;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerResponseContext;
import jakarta.ws.rs.container.ContainerResponseFilter;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.ResponseBuilder;
import jakarta.ws.rs.ext.Provider;

@Provider
@Path("/projeto/vistoria")
public class VistoriaResource implements ContainerResponseFilter{

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response findAll() {
		ArrayList<Vistoria> resposta = VistoriaRepository.findAll();
		ResponseBuilder response = Response.ok();
		response.entity(resposta);
		return response.build();
	}

	
	@POST 
	@Consumes(MediaType.APPLICATION_JSON)
	public Response save(@Valid Vistoria vist) {
		Vistoria resposta = VistoriaRepository.save(vist);
		ResponseBuilder response = null;
		
		if (resposta != null) {
			response = Response.created(null);
		} else {
			response = Response.status(400);
		}
		response.entity(resposta);
		return response.build();
	}
	
	
	@DELETE
	@Path("/{id}")
	public Response delete(@PathParam("id") int id) {
		if (VistoriaRepository.delete(id)) {
			ResponseBuilder response = Response.noContent();
			return response.build();
		} else {
			ResponseBuilder response = Response.status(400);
			return response.build();
		}
	}
	
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update (@Valid Vistoria vist) {
		Vistoria resposta = VistoriaRepository.update(vist);
		
		ResponseBuilder response = null;
		
		if (resposta != null) {
			response = Response.created(null);
		} else {
			response = Response.status(400);
		}
		response.entity(resposta);
		return response.build();
	}
	@Override
	public void filter(ContainerRequestContext requestContext, ContainerResponseContext ResponseContext)
			throws IOException{
		ResponseContext.getHeaders().add("Acess-Control-Allow-Origin", "*");
		ResponseContext.getHeaders().add("Acess-Control-Allow-Credentials", "true");
		ResponseContext.getHeaders().add("Acess-Control-Allow-Headers", "origin, content-type, accept, authorization");
		ResponseContext.getHeaders().add("Acess-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD");
	}
}
