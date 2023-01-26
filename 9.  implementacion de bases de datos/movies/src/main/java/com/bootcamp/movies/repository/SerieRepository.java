package com.bootcamp.movies.repository;

import com.bootcamp.movies.model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SerieRepository extends JpaRepository<Serie, Integer> {
}
