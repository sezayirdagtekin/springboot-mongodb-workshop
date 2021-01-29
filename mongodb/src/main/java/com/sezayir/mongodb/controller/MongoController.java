package com.sezayir.mongodb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sezayir.mongodb.model.Application;
import com.sezayir.mongodb.service.ApplicationService;


@RestController
public class MongoController {
	
@Autowired
private ApplicationService applicationService;


@RequestMapping(value="applications",method=RequestMethod.GET)
public List<Application> getAllApplications(){
	return applicationService.getAllApplications();
}
	

}
