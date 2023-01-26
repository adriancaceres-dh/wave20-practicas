package com.bootcamp.MoviesHQL.repository;

import com.bootcamp.MoviesHQL.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
public interface IMovieRepository extends JpaRepository<Movie, Integer> {
    @Query("FROM Movie WHERE genre.name = :genre")
    List<Movie> findByGenre(String genre);

}
