package com.bootcamp.movies_hql.repository;

import com.bootcamp.movies_hql.model.Series;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Set;

public interface ISeriesRepository extends JpaRepository<Series, Integer> {

    @Query("FROM series AS s WHERE s.seasons.size > :count")
    Set<Series> findBySeasonCountGreaterThan(@Param("count") Integer count);
}
