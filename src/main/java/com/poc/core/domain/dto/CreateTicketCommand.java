package com.poc.core.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class CreateTicketCommand {

	@NotBlank(message = "Plate is required", groups = { CreateTicketCommand.class, NotBlank.class })
	private String plate;

	@NotNull(message = "Created date is required", groups = { CreateTicketCommand.class, NotNull.class })
	@Past(message = "Created date must be valid date", groups = { CreateTicketCommand.class, Past.class })
	private LocalDateTime createdAt;

	@NotBlank(message = "ParkingId is required", groups = { CreateTicketCommand.class, NotNull.class })
	private String parkingId;

}
