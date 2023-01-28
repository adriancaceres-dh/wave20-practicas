package com.example.peliculas.repository;

import com.example.peliculas.entity.Actor;
import com.example.peliculas.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMovieRepository extends JpaRepository<Movie,Long> {

    @Query("SELECT m.actors from Movie m where  m.title = :movie")
    List<Actor> findActorsByMovie(String movie);

    //@Query("select m from Movie m join Actor a where a.rating > :rating ")
    //@Query("select m from Movie m join Actor a where exists ( From Actor ac where ac.rating > :rating)")
    @Query("select m from Movie m join Actor a where a.rating < :rating")
    List<Movie> findByMovie(@Param("rating") Double rating);
}
