package com.example.practicaHQL.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.sql.Timestamp;

@Entity
@Table(name = "actor_episode")
public class ActorEpisode {
    private Integer actorId;
    private Timestamp createdAt;
    private Integer episodeId;
    @Id
    private Integer id;
    private Timestamp updatedAt;
}
