package com.sezayir.mongodb.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import com.sezayir.mongodb.model.Application;
import com.sezayir.mongodb.repository.ApplicationRepository;

@Component
public class ApplicationDao {

	@Autowired
	private ApplicationRepository repository;

	@Autowired
	private MongoTemplate mongoTemplate;

	public List<Application> getAllApplications() {
		return repository.findAll();
	}

	public Optional<Application> getApplicationById(String id) {
		return repository.findById(id);
	}

	public Optional<Application> findApplicationByName(String name) {
		return repository.findByName(name);
	}

	public void addNewApplicationUsingMongoTemplate(Application application) {
		mongoTemplate.insert(application);
	}

	public void deleteApplicationById(Application application) {
		mongoTemplate.remove(application);
	}

}
