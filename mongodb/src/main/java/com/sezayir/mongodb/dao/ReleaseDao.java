package com.sezayir.mongodb.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sezayir.mongodb.model.Release;
import com.sezayir.mongodb.repository.ReleaseRepository;

@Component
public class ReleaseDao {

	@Autowired
	private ReleaseRepository repository;

	public List<Release> getAllApplications() {
		return repository.findAll();
	}

}
