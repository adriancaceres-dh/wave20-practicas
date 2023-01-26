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

    @Query("SELECT DISTINCT am.movie FROM ActorMovie am WHERE am.movie.id IN ( SELECT am2.movie.id FROM ActorMovie am2 WHERE am2.actor.rating > :aboveRating GROUP BY am2.movie.id HAVING COUNT(am2.actor) = (SELECT COUNT(am3.actor) FROM ActorMovie am3 WHERE am3.movie = am2.movie))")
    List<Movie> findMoviesWhichActorsHasRatingAbove(Double aboveRating);
}
