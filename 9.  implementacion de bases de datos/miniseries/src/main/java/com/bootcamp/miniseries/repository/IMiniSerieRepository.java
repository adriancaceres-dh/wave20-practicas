package com.bootcamp.miniseries.repository;

import com.bootcamp.miniseries.model.MiniSerie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMiniSerieRepository extends JpaRepository<MiniSerie, Long> {
}
