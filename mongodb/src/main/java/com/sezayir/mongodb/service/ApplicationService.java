package com.sezayir.mongodb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sezayir.mongodb.dao.ApplicationDao;
import com.sezayir.mongodb.dao.TicketDao;
import com.sezayir.mongodb.model.Application;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class ApplicationService {

	@Autowired
	private ApplicationDao dao;

	@Autowired
	private TicketDao ticketDao;
	

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

	public void deleteApplicationById(String id) {
		dao.deleteApplicationById(id);
	}

	public void updateApplicationUsingMongoTemplate(Application application) {
		dao.updateApplicationUsingMongoTemplate(application);
	}

	@Transactional
	public void retireApplication(Application application) {
		log.info("Transaction start...");
		dao.deleteApplicationById(application);
		ticketDao.cancelTicket(application);
		log.info("Transaction end...");
	}

}
