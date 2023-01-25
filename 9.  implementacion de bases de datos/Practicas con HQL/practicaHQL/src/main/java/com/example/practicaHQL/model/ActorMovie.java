package com.example.practicaHQL.model;

import jakarta.persistence.Entity;

import java.sql.Timestamp;

@Entity
public class ActorMovie {

    private Integer actorId;
    private Timestamp createdAt;
    private Integer id;
    private Integer movieId;
    private Timestamp updatedAt;
}
