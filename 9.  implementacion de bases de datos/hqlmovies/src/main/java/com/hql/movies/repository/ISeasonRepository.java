package com.hql.movies.repository;

import com.hql.movies.model.Season;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ISeasonRepository extends JpaRepository<Season, Integer> {
}
