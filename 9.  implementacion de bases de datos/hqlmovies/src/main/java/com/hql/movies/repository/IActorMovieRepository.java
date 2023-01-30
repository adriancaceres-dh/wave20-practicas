package com.hql.movies.repository;

import com.hql.movies.model.Actor;
import com.hql.movies.model.intermediate.ActorMovie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IActorMovieRepository extends JpaRepository<ActorMovie, Integer> {

    @Query("select distinct am.actor from ActorMovie am where am.movie.title like %:title%")
    List<Actor> findAllActorsInMovie(@Param("title") String movieTitle);
}
