package com.bootcamp.hql_movies.repository;

import com.bootcamp.hql_movies.model.Actor;
import com.bootcamp.hql_movies.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface IActorRepository extends JpaRepository<Actor, Integer> {

    @Query("from Actor a where a.favoriteMovie is not null")
    List<Actor> findWithFavoriteMovie();

    List<Actor> findByFavoriteMovieIsNotNull();

    @Query("from Actor a where a.rating > :value")
    List<Actor> findActorsWithRatingGreaterThan(@Param("value") BigDecimal value);

    List<Actor> findByRatingGreaterThan(BigDecimal value);

    @Query("from Actor a inner join a.movies as movie where movie like :movie")
    List<Actor> findActorByMovieQuery(@Param("movie") Movie movie);
}
