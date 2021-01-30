package com.sezayir.mongodb.dao;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sezayir.mongodb.model.Ticket;
import com.sezayir.mongodb.repository.TicketRepository;

@Component
public class TicketDao {

	@Autowired
	private TicketRepository repository;

	public List<Ticket> getAllTickets() {
		return repository.findAll();
	}

	public List<Ticket> findTicketByStatus(String status) {
		return repository.findByStatus(status);
	}

	public Stream<Ticket> countAllTicketsByStatus(String status) {
		return repository.countAllTicketsByStatus(status);
	}

}
