package com.sezayir.mongodb.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import com.sezayir.mongodb.model.Release;
import com.sezayir.mongodb.repository.ReleaseRepository;

@Component
public class ReleaseDao {

	@Autowired
	private ReleaseRepository repository;

	@Autowired
	MongoTemplate mongoTemplate;

	public List<Release> getAllReleases() {
		return repository.findAll();
	}

	public void insert(Release release) {
		repository.insert(release);

	}

	public List<Release> getAllReleasesByTicketStatus(String status) {

		Query query= new Query();
		query.addCriteria(Criteria.where("tickets.status").is(status));
		
		return mongoTemplate.find(query, Release.class);
	}

}
