package com.sezayir.mongodb.model;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Document
@Data
public class Release {

	@Id
	private String id;
	private String name;
	private String description;
	private List<Ticket> tickets;
	private LocalDate releaseDate;
    //private ZonedDateTime releaseDate;  //need to converter

	@Transient
	@Getter(value = AccessLevel.NONE)
	@Setter(value = AccessLevel.NONE)
	private Double estimatedCosts;

	
	public Double getEstimatedCosts() {
		return tickets.size() * 15.50;
	}
}
