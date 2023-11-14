package br.com.fiap.projeto.controller;

import java.util.ArrayList;

import br.com.fiap.projeto.model.entity.Bicicleta;
import br.com.fiap.projeto.model.repository.BicicletaRepository;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.ResponseBuilder;


@Path("/projeto/bicicleta")
public class BicicletaResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)

	public Response findAll() {
		ArrayList<Bicicleta> resposta = BicicletaRepository.findAll();
		ResponseBuilder response = Response.ok();
		response.entity(resposta);
		return response.build();
	}

	
	@POST 
	@Consumes(MediaType.APPLICATION_JSON)
	public Response save(@Valid Bicicleta bike) {
		Bicicleta resposta = BicicletaRepository.save(bike);
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
	@Path("/{numSerie}")
	public Response delete(@PathParam("numSerie") int numSerie) {
		if (BicicletaRepository.delete(numSerie)) {
			ResponseBuilder response = Response.noContent();
			return response.build();
		} else {
			ResponseBuilder response = Response.status(400);
			return response.build();
		}
	}
	
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update (@Valid Bicicleta bike) {
		Bicicleta resposta = BicicletaRepository.update(bike);
		
		ResponseBuilder response = null;
		
		if (resposta != null) {
			response = Response.created(null);
		} else {
			response = Response.status(400);
		}
		response.entity(resposta);
		return response.build();
	}
}
