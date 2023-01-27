package com.bootcamp.MoviesHQL.repository;

import com.bootcamp.MoviesHQL.model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ISerieRepository extends JpaRepository<Serie, Integer> {
    @Query("SELECT DISTINCT s FROM Serie s WHERE s.seasons.size > :seasonNumber")
    List<Serie> findBySeasonsIdGreaterThan(Integer seasonNumber);
}
