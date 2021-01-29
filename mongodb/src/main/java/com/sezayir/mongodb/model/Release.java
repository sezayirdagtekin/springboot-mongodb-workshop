package com.sezayir.mongodb.model;

import java.time.LocalDate;
import java.util.List;

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
public class Release {

	@Id
	private String id;
	private String name;
	private String description;
	private List<Ticket> tickets;
	private LocalDate releaseDate;
}
