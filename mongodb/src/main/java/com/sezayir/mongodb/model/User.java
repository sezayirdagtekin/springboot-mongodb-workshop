package com.sezayir.mongodb.model;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import lombok.Data;
import lombok.ToString;




@Document
@Data
@ToString
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class User {
    private String userName;
    private String firstName;
    private String lastName;
    private String email;


}

