package com.sezayir.mongodb.repository;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import com.sezayir.mongodb.model.Ticket;

@Repository
public interface TicketRepository extends MongoRepository<Ticket, String> {

	List<Ticket>  findByStatus(String status);
	
	@Query("{ 'status':?0}")
	Stream<Ticket> countAllTicketsByStatus(String status);

	List<Ticket> findByAppId(String appId);

}
