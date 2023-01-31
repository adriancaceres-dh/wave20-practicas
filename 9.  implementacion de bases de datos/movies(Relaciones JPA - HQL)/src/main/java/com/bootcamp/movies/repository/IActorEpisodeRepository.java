package com.bootcamp.movies.repository;

import com.bootcamp.movies.entity.Episode;
import com.bootcamp.movies.entity.intermediate.ActorEpisode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IActorEpisodeRepository extends JpaRepository<ActorEpisode, Integer>{

    @Query("SELECT a_e.episode FROM ActorEpisode a_e WHERE a_e.actor.id = :actorId")
    List<Episode> findEpisodesByActor(Integer actorId);
}
