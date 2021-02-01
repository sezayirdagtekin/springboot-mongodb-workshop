package com.sezayir.mongodb.dao;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import com.sezayir.mongodb.model.Application;
import com.sezayir.mongodb.model.Ticket;
import com.sezayir.mongodb.repository.TicketRepository;

import ch.qos.logback.classic.Logger;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;

@Component
@Log4j2
public class TicketDao {

	@Autowired
	private TicketRepository repository;

	@Autowired
	private MongoTemplate mongoTemplate;

	public List<Ticket> getAllTickets() {
		return repository.findAll();
	}

	public List<Ticket> findTicketByStatus(String status) {
		return repository.findByStatus(status);
	}

	public Stream<Ticket> countAllTicketsByStatus(String status) {
		return repository.countAllTicketsByStatus(status);
	}

	public List<Ticket> findTicketByAppId(String appId) {
		return repository.findByAppId(appId);
	}

	public void cancelTicket(Application application) {
		Query query = new Query();

		query.addCriteria(Criteria.where("appId").is(application.getId()));
		Update update = new Update();
		update.set("status", "Cancel");
		mongoTemplate.updateMulti(query, update, Ticket.class);
		log.info("Ticket canceled"+query.toString());
	
	}
}
