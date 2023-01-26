package com.example.practicaHQL.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.sql.Timestamp;

@Entity
@Table(name = "actor_episode")
public class ActorEpisode {
    @Id
    private Integer id;
   /* @ManyToOne
    private Actor actorId;
    private Timestamp createdAt;
    @ManyToOne
    private Episode episodeId;
    private Timestamp updatedAt;*/
}
