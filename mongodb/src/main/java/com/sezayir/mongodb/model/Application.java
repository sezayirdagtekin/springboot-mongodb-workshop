package com.sezayir.mongodb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Document
@Getter
@Setter
@ToString
@AllArgsConstructor
public class Application {

	@Id
	private String id;
	
	private String name;
	
	private String description;
	
	private String owner;
}
