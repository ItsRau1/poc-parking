package com.poc.inbound.controller;

import com.poc.core.domain.dto.CreateTicketCommand;
import com.poc.core.domain.entity.Ticket;
import com.poc.core.usecase.ticket.CreateTicket;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/v1/ticket")
public class TicketController {

	@Inject
	CreateTicket createTicket;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createTicket(CreateTicketCommand command) {
		Ticket ticket = createTicket.execute(command);
		return Response.status(Response.Status.CREATED).entity(ticket).build();
	}

}
