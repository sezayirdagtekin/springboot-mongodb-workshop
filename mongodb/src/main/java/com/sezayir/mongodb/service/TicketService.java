package com.sezayir.mongodb.service;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sezayir.mongodb.dao.TicketDao;
import com.sezayir.mongodb.model.Ticket;

@Service
public class TicketService {

	@Autowired
	private TicketDao dao;

	public List<Ticket> getAllTickets() {
		return dao.getAllTickets();
	}

	public List<Ticket> findTicketByStatus(String status) {
		return dao.findTicketByStatus(status);
	}

	public Long countAllTicketsByStatus(String status) {
		Stream<Ticket> stream = dao.countAllTicketsByStatus(status);
		Long count = stream.count();
		stream.close();
		return count;
	}

	public List<Ticket> findTicketByAppId(String appId) {
		 return dao.findTicketByAppId(appId);
	}

}
