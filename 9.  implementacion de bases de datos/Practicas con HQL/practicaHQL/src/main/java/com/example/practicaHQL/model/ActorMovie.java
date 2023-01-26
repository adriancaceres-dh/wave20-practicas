package com.example.practicaHQL.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.sql.Timestamp;

@Entity
@Table(name = "actor_movie")
public class ActorMovie {
    private Integer actorId;
    private Timestamp createdAt;
    @Id
    private Integer id;
    private Integer movieId;
    private Timestamp updatedAt;
}
