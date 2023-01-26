package com.bootcamp.movies.repository;

import com.bootcamp.movies.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Integer> {
}
