package com.bootcamp.movies.repository;

import com.bootcamp.movies.model.Episode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EpisodeRepository extends JpaRepository<Episode, Integer> {
}
