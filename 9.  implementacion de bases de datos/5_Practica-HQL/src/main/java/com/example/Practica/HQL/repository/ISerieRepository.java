package com.example.Practica.HQL.repository;

import com.example.Practica.HQL.model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ISerieRepository extends JpaRepository<Serie,Integer> {

    @Query("FROM series AS s WHERE s.seasons.size > :cantSeasons")
    List<Serie> findBySeasonsSizeGreaterThan(@Param("cantSeasons") Integer cantSeasons);

}
