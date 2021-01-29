package com.sezayir.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.sezayir.mongodb.model.Release;

@Repository
public interface  ReleaseRepository  extends  MongoRepository<Release, String>{



}
