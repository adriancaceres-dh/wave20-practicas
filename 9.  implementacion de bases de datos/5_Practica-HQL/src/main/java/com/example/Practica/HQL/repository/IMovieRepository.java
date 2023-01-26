package com.example.Practica.HQL.repository;

import com.example.Practica.HQL.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IMovieRepository extends JpaRepository<Movie,Integer> {

    List<Movie> findByRatingGreaterThan(Double rating);
    List<Movie> findByGenreIdEquals(Integer genreId);
    List<Movie> findByRatingGreaterThanAndGenreIdEquals(Double rating, Integer genreId);
}
