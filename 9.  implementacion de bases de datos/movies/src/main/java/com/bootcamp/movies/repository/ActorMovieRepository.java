package com.bootcamp.movies.repository;

import com.bootcamp.movies.model.Actor;
import com.bootcamp.movies.model.Movie;
import com.bootcamp.movies.model.intermediate.ActorMovie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ActorMovieRepository extends JpaRepository<ActorMovie, Integer> {

    @Query("SELECT am.actor FROM ActorMovie am WHERE am.movie.id = :movieId")
    List<Actor> findActorsThatWorkedInMovie(Integer movieId);

    @Query("SELECT am.movie FROM ActorMovie am WHERE am.actor.rating > :aboveRating")
    List<Movie> findMoviesWhichActorsHasRatingAbove(Double aboveRating);
}
