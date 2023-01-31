package com.bootcamp.movies.repository;

import com.bootcamp.movies.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IMoviesRepository extends JpaRepository<Movie, Integer> {
    @Query("FROM Movie WHERE genre.id = :genreId")
    List<Movie> findByGenre(Integer genreId);
}
