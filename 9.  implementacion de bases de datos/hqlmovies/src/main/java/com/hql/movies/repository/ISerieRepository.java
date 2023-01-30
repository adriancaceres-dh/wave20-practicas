package com.hql.movies.repository;

import java.util.*;

import com.hql.movies.model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ISerieRepository extends JpaRepository<Serie, Integer> {

    @Query("from Serie s where size(s.seasons) > :quantitySeasons")
    List<Serie> findAllSeriesWithMoreSeasons(@Param("quantitySeasons") Integer quantitySeasons);
}
