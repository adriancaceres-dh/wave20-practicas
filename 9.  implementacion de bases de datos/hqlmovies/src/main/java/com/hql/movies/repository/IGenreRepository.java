package com.hql.movies.repository;

import com.hql.movies.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface IGenreRepository extends JpaRepository<Genre, Integer> {
}
