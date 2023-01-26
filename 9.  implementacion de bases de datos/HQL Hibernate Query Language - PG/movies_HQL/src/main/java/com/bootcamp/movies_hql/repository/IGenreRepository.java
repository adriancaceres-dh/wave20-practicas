package com.bootcamp.movies_hql.repository;

import com.bootcamp.movies_hql.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IGenreRepository extends JpaRepository<Genre, Long> {
}
