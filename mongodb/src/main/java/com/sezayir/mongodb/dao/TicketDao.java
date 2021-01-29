package com.sezayir.mongodb.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sezayir.mongodb.model.Application;
import com.sezayir.mongodb.model.Ticket;
import com.sezayir.mongodb.repository.ApplicationRepository;
import com.sezayir.mongodb.repository.TicketRepository;

@Component
public class TicketDao {

	@Autowired
	private TicketRepository repository;

	public List<Ticket> getAllTickets() {
		return repository.findAll();
	}

}
