package com.hql.movies.repository;

import com.hql.movies.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IActorRepository extends JpaRepository<Actor, Integer> {
}
