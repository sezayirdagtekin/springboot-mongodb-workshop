package com.sezayir.mongodb.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sezayir.mongodb.model.Application;
import com.sezayir.mongodb.model.Release;
import com.sezayir.mongodb.model.Ticket;
import com.sezayir.mongodb.service.ApplicationService;
import com.sezayir.mongodb.service.ReleaseService;
import com.sezayir.mongodb.service.TicketService;

@RestController
@RequestMapping(value = "/tza")
public class MongoController {

	@Autowired
	private ApplicationService applicationService;

	@Autowired
	private ReleaseService releaseService;

	@Autowired
	private TicketService ticketService;

	@RequestMapping(value = "/applications", method = RequestMethod.GET)
	public List<Application> getAllApplications() {
		return applicationService.getAllApplications();
	}

	@RequestMapping(value = "/applications/{id}", method = RequestMethod.GET)
	public Optional<Application> getApplicationById(@PathVariable("id") String id) {
		return applicationService.getApplicationById(id);
	}

	@RequestMapping(value = "/applications/name/{name}")
	public Optional<Application> findApplicationByName(@PathVariable("name") String name) {
		return applicationService.findApplicationByName(name);
	}

	@RequestMapping(value = "/applications/template", method = RequestMethod.POST)
	public void addNewApplication(@RequestBody Application application) {
		applicationService.addNewApplicationUsingMongoTemplate(application);
	}
	

	@RequestMapping(value = "/applications/template", method = RequestMethod.DELETE)
	public void deleteApplication(@RequestBody Application application) {
		applicationService.deleteApplicationById(application);
	}


	@RequestMapping(value = "/releases/tickets", method = RequestMethod.PUT)
	public void addReleaseWithTicket(@RequestBody Release release) {
		releaseService.insert(release);
	}

	@RequestMapping(value = "/releases", method = RequestMethod.GET)
	public List<Release> getAllReleases() {
		return releaseService.getAllReleases();
	}

	@RequestMapping(value = "/tickets", method = RequestMethod.GET)
	public List<Ticket> getAllTickets() {
		return ticketService.getAllTickets();
	}

	@RequestMapping(value = "/tickets/status/{status}")
	public List<Ticket> findTicketByStatus(@PathVariable("status") String status) {
		return ticketService.findTicketByStatus(status);
	}

	@RequestMapping(value = "/tickets/count/{status}")
	public Long countAllTicketsByStatus(@PathVariable("status") String status) {
		return ticketService.countAllTicketsByStatus(status);
	}

}
