package com.bootcamp.vehiculos.repository;

import com.bootcamp.vehiculos.model.template.VehiculoPerdida;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IVehiculoPerdidaRepository extends JpaRepository<VehiculoPerdida, Long> {
}
