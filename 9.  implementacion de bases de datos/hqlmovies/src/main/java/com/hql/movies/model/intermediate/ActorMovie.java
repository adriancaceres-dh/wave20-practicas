package com.hql.movies.model.intermediate;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.hql.movies.model.Actor;
import com.hql.movies.model.ActorMovieID;
import com.hql.movies.model.Movie;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "actor_movie")
public class ActorMovie {
    @EmbeddedId
    private ActorMovieID id;
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("actorId")
    @JsonManagedReference
    private Actor actor;
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("movieId")
    @JsonManagedReference
    private Movie movie;
    private LocalDate createdAt;
    private LocalDate updatedAt;
}
