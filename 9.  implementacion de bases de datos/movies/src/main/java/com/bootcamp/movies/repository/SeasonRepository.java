package com.bootcamp.movies.repository;

import com.bootcamp.movies.model.Season;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeasonRepository extends JpaRepository<Season, Integer> {

}
