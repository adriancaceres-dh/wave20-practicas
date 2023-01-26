package com.hql.movies.repository;

import com.hql.movies.model.Episode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface IEpisodeRepository extends JpaRepository<Episode, Integer> {
}
