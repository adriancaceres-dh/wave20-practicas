package com.bootcamp.movies.repository;

import com.bootcamp.movies.entity.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.net.Inet4Address;
import java.util.List;

public interface ISerieRepository extends JpaRepository <Serie, Integer>{

    @Query("FROM Serie ser WHERE SIZE(ser.seasons) > :n")
    List<Serie> findByNumberOfSeasonsGreaterThan(Integer n);
}
