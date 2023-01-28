package com.example.peliculas.repository;

import ch.qos.logback.core.model.INamedModel;
import com.example.peliculas.entity.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ISerieRepository extends JpaRepository<Serie,Long> {

    @Query("from Serie s WHERE size(s.seasons) > :number ")
    List<Serie> findAllBySeasonsNumber(Integer number);
}
