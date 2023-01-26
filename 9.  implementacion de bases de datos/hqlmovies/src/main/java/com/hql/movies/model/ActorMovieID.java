package com.hql.movies.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ActorMovieID implements Serializable {
    @Column(name = "actor_id")
    private Integer actorId;
    @Column(name = "movie_id")
    private Integer movieId;

    public ActorMovieID() {}

    public ActorMovieID(Integer actorId, Integer movieId) {
        this.actorId = actorId;
        this.movieId = movieId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActorMovieID that = (ActorMovieID) o;
        return actorId.equals(that.actorId) && movieId.equals(that.movieId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(actorId, movieId);
    }
}
