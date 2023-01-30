package com.bootcamp.MiniSeries.repositoty;

import com.bootcamp.MiniSeries.entity.MiniSerie;
import org.springframework.data.jpa.repository.JpaRepository;



public interface IMiniSerieRepository extends JpaRepository<MiniSerie,Long> {
}
