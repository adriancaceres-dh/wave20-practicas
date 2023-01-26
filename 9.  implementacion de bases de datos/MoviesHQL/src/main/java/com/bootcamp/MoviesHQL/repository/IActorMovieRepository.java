package com.bootcamp.MoviesHQL.repository;

import com.bootcamp.MoviesHQL.model.ActorMovie;
import com.bootcamp.MoviesHQL.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
public interface IActorMovieRepository extends JpaRepository<ActorMovie, Integer> {
    @Query("SELECT am.movie FROM ActorMovie am WHERE am.actor.rating > :rating")
    List<Movie> findMovieByActorRating(Double rating);
}
