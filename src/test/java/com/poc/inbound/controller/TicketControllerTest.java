package com.poc.inbound.controller;

import com.poc.core.domain.dto.CreateTicketCommand;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.UUID;

import static io.restassured.RestAssured.given;

@QuarkusTest
public class TicketControllerTest {

	@Test
	@DisplayName("Should be able to create a ticket")
	void shouldBeAbleToCreateTicket() {
		CreateTicketCommand command = CreateTicketCommand.builder()
			.createdAt(LocalDateTime.now().minusMinutes(2))
			.plate(UUID.randomUUID().toString().substring(0, 8))
			.parkingId("1")
			.build();
		given().log()
			.all()
			.when()
			.header("Content-Type", "application/json")
			.body(command)
			.post("/v1/ticket")
			.then()
			.statusCode(201);
	}

}
