package com.example.Practica.HQL.repository;

import com.example.Practica.HQL.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface IActorRepository extends JpaRepository <Actor,Integer>{

    List<Actor> findByFavoriteMovieIsNotNull();
    List<Actor> findByFavoriteMovieIsNotNullAndRatingGreaterThan(Double rating);
    List<Actor> findByRatingGreaterThan(Double rating);

    @Query("FROM actors AS a JOIN a.actorMovies AS am "+
            "WHERE am.movie.id = :movieId "+
            "AND a.rating > :ratingValue "+
            "AND a.favoriteMovie IS NOT NULL")
    List<Actor> findByFavoriteMovieIsNotNullAndRatingGreaterThanAndMovieLike(@Param("ratingValue")Double rating, @Param("movieId") Integer movieId);
    @Query("FROM actors AS a JOIN a.actorMovies AS am "+
            "WHERE am.movie.id = :movieId "+
            "AND a.rating > :ratingValue")
    List<Actor> findByRatingGreaterThanAndMovieLike(@Param("ratingValue") Double rating,@Param("movieId") Integer movieId);
    @Query("FROM actors AS a JOIN a.actorMovies AS am "+
            "WHERE am.movie.id = :movieId "+
            "AND a.favoriteMovie IS NOT NULL")
    List<Actor> findByFavoriteMovieIsNotNullAndMovieLike(@Param("movieId") Integer movieId);
    @Query("FROM actors AS a JOIN a.actorMovies AS am "+
            "WHERE a.favoriteMovie IS NOT NULL")
    List<Actor> findByMovieLike(@Param("movieId") Integer movieId);

}
