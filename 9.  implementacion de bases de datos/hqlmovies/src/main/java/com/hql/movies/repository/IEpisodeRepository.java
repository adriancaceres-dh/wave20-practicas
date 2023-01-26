package com.hql.movies.repository;

import com.hql.movies.model.Episode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEpisodeRepository extends JpaRepository<Episode, Integer> {
}
