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
public class Ticket {

    @Id
    private String id;
    private String title;
    private String description;
    private String appId;
    private String status;


}
