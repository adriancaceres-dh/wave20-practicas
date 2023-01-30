package com.hql.movies.repository;

import com.hql.movies.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IActorRepository extends JpaRepository<Actor, Integer> {

    @Query("from Actor a where a.rating >= :rating")
    List<Actor> findActorsByRatingGreaterThanEqual(@Param("rating") Double rating);
}
