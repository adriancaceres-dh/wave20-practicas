package com.bootcamp.MiniSeries.repository;

import com.bootcamp.MiniSeries.model.MiniSerie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMiniserieRepository extends JpaRepository<MiniSerie, Long> {
}
