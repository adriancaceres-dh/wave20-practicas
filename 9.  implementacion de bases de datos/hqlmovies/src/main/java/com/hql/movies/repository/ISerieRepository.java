package com.hql.movies.repository;

import com.hql.movies.model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISerieRepository extends JpaRepository<Serie, Integer> {
}
