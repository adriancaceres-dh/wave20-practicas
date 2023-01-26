package com.hql.movies.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ActorEpisodeID implements Serializable {
    @Column(name = "actor_id")
    private Integer actorId;
    @Column(name = "episode_id")
    private Integer episodeId;

    public ActorEpisodeID(Integer actorId, Integer episodeId) {
        this.actorId = actorId;
        this.episodeId = episodeId;
    }

    public ActorEpisodeID() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActorEpisodeID that = (ActorEpisodeID) o;
        return actorId.equals(that.actorId) && episodeId.equals(that.episodeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(actorId, episodeId);
    }
}
