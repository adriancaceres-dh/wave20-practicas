package com.hql.movies.repository;

import com.hql.movies.model.Season;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISeasonRepository extends JpaRepository<Season, Integer> {
}
