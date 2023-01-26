package com.example.practicaHQL.model;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "actor_movie")
public class ActorMovie {
    @Id
    private Integer id;
/*    @ManyToOne
    private Actor actorId;
    private Timestamp createdAt;
    @ManyToOne
    private Movie movieId;
    private Timestamp updatedAt;*/
}
