package com.bootcamp.MoviesHQL.repository;

import com.bootcamp.MoviesHQL.model.Actor;
import com.bootcamp.MoviesHQL.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IActorRepository extends JpaRepository<Actor, Integer> {
    List<Actor> findActorByMovieIsNotNull();
    List<Actor> findActorByRatingGreaterThan(Double rating);
    @Query("FROM Actor WHERE movie.title = :movie")
    List<Actor> findActorByMovieTitleEquals(String movie);
}
