package com.bootcamp.movies.repository;

import com.bootcamp.movies.entity.Actor;
import com.bootcamp.movies.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IActorRepository extends JpaRepository<Actor, Integer> {

    List<Actor> findByFavoriteMovieNotNull();

    List<Actor> findByRatingGreaterThan(Double rating);

}
