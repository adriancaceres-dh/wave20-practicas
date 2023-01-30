package com.bootcamp.movies.repository;

import com.bootcamp.movies.model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SerieRepository extends JpaRepository<Serie, Integer> {

    @Query("FROM Serie s WHERE SIZE(s.seasons) > :amountOfSeasons")
    List<Serie> findAllSeriesWhenHaveMoreSeasonsThan(Integer amountOfSeasons);
}
