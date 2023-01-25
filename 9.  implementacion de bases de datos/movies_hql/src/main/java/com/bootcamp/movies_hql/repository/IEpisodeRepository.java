package com.bootcamp.movies_hql.repository;

import com.bootcamp.movies_hql.model.Episode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Set;

public interface IEpisodeRepository extends JpaRepository<Episode, Integer> {

    @Query("FROM episodes AS e JOIN e.actorEpisodes AS ae WHERE ae.actor.id = :actorId")
    Set<Episode> findByActorId(@Param("actorId") Integer actorId);
}
