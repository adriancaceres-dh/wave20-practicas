package com.bootcamp.movies.repository;

import com.bootcamp.movies.entity.Actor;
import com.bootcamp.movies.entity.Movie;
import com.bootcamp.movies.entity.intermediate.ActorMovie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IActorMovieRepository extends JpaRepository<ActorMovie, Integer> {

    @Query("SELECT a_m.actor FROM ActorMovie a_m WHERE a_m.movie.id = :movieId")
    List<Actor> findActorsOfTheMovie(Integer movieId);

}
