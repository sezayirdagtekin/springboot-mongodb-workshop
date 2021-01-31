package com.sezayir.mongodb.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.sezayir.mongodb.model.Application;

@Repository
public interface ApplicationRepository extends  MongoRepository<Application, String> {

	Optional<Application> findByName(String name);

}
