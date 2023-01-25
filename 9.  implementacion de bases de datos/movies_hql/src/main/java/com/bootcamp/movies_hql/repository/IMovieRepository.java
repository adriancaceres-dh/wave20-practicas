package com.bootcamp.movies_hql.repository;

import com.bootcamp.movies_hql.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Set;

public interface IMovieRepository extends JpaRepository<Movie, Integer> {

    @Query("FROM movies AS m WHERE m.actorMovies.size != 0 AND m.actorMovies.size = (SELECT COUNT(*) FROM actor_movie AS am WHERE am.movie.id = m.id AND am.actor.rating > :rating)")
    Set<Movie> findByActorRatingGreaterThan(@Param("rating") Double rating);

    Set<Movie> findByGenreIdEquals(Integer genreId);

    @Query("FROM movies AS m WHERE m.actorMovies.size > :count")
    Set<Movie> findByActorCountGreaterThan(@Param("count") Integer count);
}
