package com.poc.core.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Ticket {

	private String id;

	private LocalDateTime createdAt;

	private LocalDateTime endedAt;

	private String plate;

	private Parking parking;

	@JsonIgnore
	private Boolean opened = true;

	public void toClose(LocalDateTime endedAt) {
		opened = false;
		this.endedAt = endedAt;
	}

	public void register() {
		this.id = UUID.randomUUID().toString();
	}

}
