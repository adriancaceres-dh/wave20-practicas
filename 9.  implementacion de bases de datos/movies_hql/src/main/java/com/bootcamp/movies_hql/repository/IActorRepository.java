package com.bootcamp.movies_hql.repository;

import com.bootcamp.movies_hql.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Set;

public interface IActorRepository extends JpaRepository<Actor, Integer> {

    Set<Actor> findByFavoriteMovieNotNull();

    Set<Actor> findByRatingGreaterThan(Double rating);

    @Query("FROM actors AS a JOIN a.actorMovies AS am WHERE am.movie.id = :movieId")
    Set<Actor> findByMovieWorkedIn(@Param("movieId") Integer movieId);
}
