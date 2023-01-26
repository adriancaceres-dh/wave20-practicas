package com.bootcamp.seguros.repository;

import com.bootcamp.seguros.model.Vehicle;
import com.bootcamp.seguros.model.templates.PatenteYMarca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    @Query("SELECT ve.patente FROM Vehicle ve")
    List<String> getAllPatentes();
    @Query("SELECT new com.bootcamp.seguros.model.templates.PatenteYMarca(v.patente, v.marca) FROM Vehicle v ORDER BY v.anoDeFabricacion")
    List<PatenteYMarca> getAllPatenteYMarca();
    @Query("SELECT v.patente FROM Vehicle v WHERE v.cantidadDeRuedas >= 4 AND YEAR(v.anoDeFabricacion) = YEAR (SYSDATE())")
    List<String> getAllPatentesByCantidadDeRuedas();
}
