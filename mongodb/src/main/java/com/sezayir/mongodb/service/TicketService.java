package com.sezayir.mongodb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sezayir.mongodb.dao.TicketDao;
import com.sezayir.mongodb.model.Ticket;

@Service
public class TicketService {

	@Autowired
	private TicketDao ticketDao;

	public List<Ticket> getAllApplications() {
		return ticketDao.getAllTickets();
	}

}
