package com.example.peliculas.repository;

import com.example.peliculas.entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IActorRepository extends JpaRepository<Actor,Long> {

     List<Actor> findActorByFavoriteMovieIsNotNull();

     List<Actor> findActorByRatingGreaterThan(Double rating);

     @Query("select m.actors from Actor a JOIN Movie m where m.title = :movie")
     List<Actor> findActorsByMovie(String movie);
}
