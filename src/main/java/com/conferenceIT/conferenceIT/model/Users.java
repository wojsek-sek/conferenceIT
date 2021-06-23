package com.conferenceIT.conferenceIT.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Users {

    @Id
    private long id;
    private String login;
    private String mail;


}
