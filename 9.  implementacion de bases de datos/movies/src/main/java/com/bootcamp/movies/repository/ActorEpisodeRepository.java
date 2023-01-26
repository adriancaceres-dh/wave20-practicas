package com.bootcamp.movies.repository;

import com.bootcamp.movies.model.Episode;
import com.bootcamp.movies.model.intermediate.ActorEpisode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ActorEpisodeRepository extends JpaRepository<ActorEpisode, Integer> {
    @Query("SELECT ae.episode FROM ActorEpisode ae WHERE ae.actor.id = :actorId")
    List<Episode> findAllEpisodesWhichWorkedActor(Integer actorId);
}
