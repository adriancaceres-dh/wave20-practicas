package com.example.Practica.HQL.repository;

import com.example.Practica.HQL.model.Episode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IEpisodeRepository extends JpaRepository<Episode,Integer> {

/*    @Query("FROM episodes AS e JOIN e.actorEpisodes AS ae "+
            "WHERE concat(ae.actor.first_name,' ',ae.actor.last_name) = :actorName")
    List<Episode> findByFullNameLike(@Param("actorName") String actorName);*/

}
