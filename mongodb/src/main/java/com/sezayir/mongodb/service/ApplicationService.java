package com.sezayir.mongodb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sezayir.mongodb.dao.ApplicationDao;
import com.sezayir.mongodb.model.Application;

@Service
public class ApplicationService {

	@Autowired
	private ApplicationDao dao;

	public List<Application> getAllApplications() {
		return dao.getAllApplications();
	}

	public Optional<Application> getApplicationById(String id) {
		return dao.getApplicationById(id);
	}

	public Optional<Application> findApplicationByName(String name) {
		return dao.findApplicationByName(name);
	}

	public void addNewApplicationUsingMongoTemplate(Application application) {
		dao.addNewApplicationUsingMongoTemplate(application);
	}

	public void deleteApplicationById(Application application) {
		dao.deleteApplicationById(application);
	}

}
