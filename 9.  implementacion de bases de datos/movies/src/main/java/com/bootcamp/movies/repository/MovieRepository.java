package com.bootcamp.movies.repository;

import com.bootcamp.movies.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
    List<Movie> findAllByGenreId(Integer id);
}
