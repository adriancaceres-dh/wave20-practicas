package com.bootcamp.movies_hql.repository;

import com.bootcamp.movies_hql.entity.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ISerieRepository extends JpaRepository<Serie, Long> {

    // Listar todas las series que tengan más de <cantidad de temporadas recibida por parámetro>
    @Query("Select s.serie from Season s group by s.serie having count(s) >= :cant_season")
    List<Serie> findSerieByNumberSeason(@Param("cant_season") int cant_season);

}
