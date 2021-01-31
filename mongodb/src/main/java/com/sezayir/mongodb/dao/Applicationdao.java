package com.sezayir.mongodb.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
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

	public void deleteApplicationById(String id) {
		repository.deleteById(id);

	}
	
	//send just this body in  postman: {"name":"Trainer Sezayir"} 
	public void updateApplicationUsingMongoTemplate(Application application) {
      Query query = new Query();
      query.addCriteria(Criteria.where("name").is(application.getName()));
      Update update= new Update();
      update.set("name","Trainer Sezayir");
      update.set("description", "Mongo course in action!!");
      mongoTemplate.updateFirst(query, update,Application.class);//update first record  founded
    
		
	}

}
