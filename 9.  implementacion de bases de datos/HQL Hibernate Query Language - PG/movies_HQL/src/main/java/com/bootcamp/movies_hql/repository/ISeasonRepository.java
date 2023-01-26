package com.bootcamp.movies_hql.repository;

import com.bootcamp.movies_hql.entity.Season;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISeasonRepository extends JpaRepository<Season, Long> {
}
