package com.ej_hql.movies.repository;

import com.ej_hql.movies.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMovieRepository extends JpaRepository<Movie, Integer> {
}
