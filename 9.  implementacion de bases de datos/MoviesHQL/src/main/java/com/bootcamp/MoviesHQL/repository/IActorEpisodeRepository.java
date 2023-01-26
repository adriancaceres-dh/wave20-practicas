package com.bootcamp.MoviesHQL.repository;

import com.bootcamp.MoviesHQL.model.ActorEpisode;
import com.bootcamp.MoviesHQL.model.Episode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IActorEpisodeRepository extends JpaRepository<ActorEpisode, Integer> {
    @Query("SELECT ae.episode FROM ActorEpisode ae WHERE ae.actor.firstName = :firstName AND ae.actor.lastName = :lastName")
    List<Episode> findEpisodeByActor(String firstName, String lastName);

}
