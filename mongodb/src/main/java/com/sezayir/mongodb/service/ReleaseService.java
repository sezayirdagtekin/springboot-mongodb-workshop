package com.sezayir.mongodb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sezayir.mongodb.dao.ReleaseDao;
import com.sezayir.mongodb.model.Release;
import com.sezayir.mongodb.repository.ReleaseRepository;

@Service
public class ReleaseService {

	@Autowired
	private ReleaseDao dao;

	public List<Release> getAllApplications() {
		return dao.getAllApplications();
	}

}
