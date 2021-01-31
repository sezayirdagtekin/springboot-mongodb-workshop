package com.sezayir.mongodb.dao;

import java.util.List;
import java.util.Optional;

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

		Query query = new Query();
		query.addCriteria(Criteria.where("tickets.status").is(status));

		return mongoTemplate.find(query, Release.class);
	}

	public void updateRelease(Release release) {
		repository.save(release);
	}

	public Double getReleaseCost(String id) {
		Optional<Release> release = repository.findById(id);
		return release.isPresent() ? release.get().getEstimatedCosts() : 0;

	}

}
