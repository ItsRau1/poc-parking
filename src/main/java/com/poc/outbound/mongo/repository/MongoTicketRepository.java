package com.poc.outbound.mongo.repository;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.poc.core.domain.entity.Ticket;
import com.poc.core.domain.repository.TicketRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.bson.Document;

@ApplicationScoped
public class MongoTicketRepository implements TicketRepository {

	@Inject
	MongoClient mongoClient;

	@Override
	public void save(Ticket ticket) {
		Document document = new Document().append("id", ticket.getId())
			.append("createdAt", ticket.getCreatedAt())
			.append("endedAt", ticket.getEndedAt())
			.append("plate", ticket.getPlate())
			.append("parking", ticket.getParking())
			.append("opened", ticket.getOpened());
		getCollection().insertOne(document);
	}

	private MongoCollection getCollection() {
		return mongoClient.getDatabase("parking").getCollection("ticket");
	}

}
