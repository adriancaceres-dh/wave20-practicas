package com.hql.movies.repository;

import com.hql.movies.model.intermediate.ActorEpisode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IActorEpisodeRepository extends JpaRepository<ActorEpisode, Integer> {
}
