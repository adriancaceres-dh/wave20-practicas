package com.example.peliculas.repository;

import com.example.peliculas.entity.Genre;
import com.example.peliculas.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IGenreRepository extends JpaRepository<Genre,Long> {

    @Query("SELECT g.movies from Genre g  WHERE g.name = :name")
    List<Movie> findMoviesByGenre(String name);
}
