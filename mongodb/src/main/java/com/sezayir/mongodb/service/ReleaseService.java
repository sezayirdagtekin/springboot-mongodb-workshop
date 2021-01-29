package com.sezayir.mongodb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sezayir.mongodb.dao.ReleaseDao;
import com.sezayir.mongodb.model.Release;

@Service
public class ReleaseService {

	@Autowired
	private ReleaseDao dao;

	public void insert(Release release) {
		dao.insert(release);
	}

	public List<Release> getAllReleases() {
		return dao.getAllReleases();
	}

}
