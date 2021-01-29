package com.sezayir.mongodb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sezayir.mongodb.model.Application;
import com.sezayir.mongodb.model.Release;
import com.sezayir.mongodb.service.ApplicationService;
import com.sezayir.mongodb.service.ReleaseService;


@RestController
@RequestMapping(value = "/tza")
public class MongoController {

	@Autowired
	private ApplicationService applicationService;
	
	@Autowired
	private ReleaseService releaseService;

	@RequestMapping(value = "/applications", method = RequestMethod.GET)
	public List<Application> getAllApplications() {
		return applicationService.getAllApplications();
	}
	
	@RequestMapping(value="/releases/tickets",method=RequestMethod.PUT)
	public void addReleaseWithTicket(@RequestBody Release release) {
		releaseService.insert(release);
	}
	
	@RequestMapping(value="/releases", method=RequestMethod.GET)
	public List<Release> getAllReleases(){
		return releaseService.getAllReleases();
	}

}
