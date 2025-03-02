package com.poc.core.usecase.ticket;

import com.poc.core.domain.dto.CreateTicketCommand;
import com.poc.core.domain.entity.Parking;
import com.poc.core.domain.entity.Ticket;
import io.quarkus.logging.Log;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CreateTicket {

	public Ticket execute(CreateTicketCommand command) {
		Log.info(String.format("Creating ticket: %s", command));
		Ticket ticket = Ticket.builder()
			.parking(Parking.builder().id(command.getParkingId()).build())
			.plate(command.getPlate())
			.createdAt(command.getCreatedAt())
			.build();
		Log.info(String.format("Registering ticket: %s", ticket));
		ticket.register();
		Log.info(String.format("Returning ticket created: %s", ticket.getId()));
		return ticket;
	}

}
