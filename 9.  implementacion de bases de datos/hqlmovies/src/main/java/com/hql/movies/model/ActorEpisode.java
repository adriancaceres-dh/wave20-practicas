package com.hql.movies.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "actor_episode")
public class ActorEpisode {
    @EmbeddedId
    private ActorEpisodeID id;
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("actorId")
    private Actor actor;
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("episodeId")
    private Episode episode;
    private LocalDate createdAt;
    private LocalDate updatedAt;

}
