package com.bootcamp.movies.repository;

import com.bootcamp.movies.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IGenresRepository extends JpaRepository<Genre, Integer> {
}
