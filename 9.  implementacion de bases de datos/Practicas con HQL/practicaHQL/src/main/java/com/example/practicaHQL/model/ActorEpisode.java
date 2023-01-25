package com.example.practicaHQL.model;

import jakarta.persistence.Entity;

import java.sql.Timestamp;

@Entity
public class ActorEpisode {
    private Integer actorId;
    private Timestamp createdAt;
    private Integer episodeId;
    private Integer id;
    private Timestamp updatedAt;
}
