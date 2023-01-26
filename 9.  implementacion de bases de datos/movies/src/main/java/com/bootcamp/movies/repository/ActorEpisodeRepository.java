package com.bootcamp.movies.repository;

import com.bootcamp.movies.model.intermediate.ActorEpisode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorEpisodeRepository extends JpaRepository<ActorEpisode, Integer> {
}
