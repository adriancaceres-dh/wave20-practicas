package com.mercadolibre.MiniSeries.repository;


import com.mercadolibre.MiniSeries.models.MiniSerie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMiniSerie extends JpaRepository<MiniSerie, Integer> {

}
