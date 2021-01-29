package com.sezayir.mongodb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sezayir.mongodb.dao.Applicationdao;
import com.sezayir.mongodb.model.Application;

@Service
public class ApplicationService {

	@Autowired
	private Applicationdao dao;

	public List<Application> getAllApplications() {
		return dao.getAllApplications();
	}

}
