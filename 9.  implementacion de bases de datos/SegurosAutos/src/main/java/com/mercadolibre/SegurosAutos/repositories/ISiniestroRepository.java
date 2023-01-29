package com.mercadolibre.SegurosAutos.repositories;

import com.mercadolibre.SegurosAutos.models.Siniestro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISiniestroRepository extends JpaRepository<Siniestro, Integer> {

}
