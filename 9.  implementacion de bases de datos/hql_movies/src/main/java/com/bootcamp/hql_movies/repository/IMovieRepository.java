package com.bootcamp.hql_movies.repository;

import com.bootcamp.hql_movies.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMovieRepository extends JpaRepository<Movie, Integer> {
}
