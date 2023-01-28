package com.example.peliculas.repository;

import com.example.peliculas.entity.Episode;
import jakarta.persistence.criteria.From;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IEpisodeRepository extends JpaRepository<Episode,Long> {

    @Query("select a.episodes from Actor a where a.firstName like :name")
    List<Episode> findEpisodesByActor(String name);
}
