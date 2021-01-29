package com.sezayir.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.sezayir.mongodb.model.Ticket;

@Repository
public interface TicketRepository extends MongoRepository<Ticket, String> {

}
