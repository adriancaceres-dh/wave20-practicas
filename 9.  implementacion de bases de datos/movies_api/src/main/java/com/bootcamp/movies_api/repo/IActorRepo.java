package com.bootcamp.movies_api.repo;

import com.bootcamp.movies_api.entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IActorRepo extends JpaRepository<Actor, Integer> {

    List<Actor> findByFavMovieIsNotNull();
}
