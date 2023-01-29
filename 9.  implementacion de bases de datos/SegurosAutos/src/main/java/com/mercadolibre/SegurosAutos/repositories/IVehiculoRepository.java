package com.mercadolibre.SegurosAutos.repositories;


import com.mercadolibre.SegurosAutos.models.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Repository
public interface IVehiculoRepository extends JpaRepository<Vehiculo, Integer> {



    @Query("Select new Map(v.patente as patente, v.marca as marca) from Vehiculo as v")
    List<Map<String,String>> getMarcaYPatente();
    @Query("Select new Map(v.patente as patente, v.marca as marca) from Vehiculo as v order by v.anioFabricacion")
    List<Map<String,String>> getMarcayPatenteByAnioFabricacion();

    List<Vehiculo> findVehiculosByCantidadRuedasGreaterThanAndAnioFabricacionAfter(Integer cantidad, LocalDate fechaInicio);


    @Query("Select s.vehiculo from Siniestro as s join s.vehiculo where s.perdidaEconomica>1000")
    List<Vehiculo> getBySiniestro();

    /*@Query("Select s.vehiculo from Siniestro as s where s.perdidaEconomica>1000")
    List<Vehiculo> getBySiniestro();*/

    @Query("Select new Map(s.vehiculo.marca, s.vehiculo.modelo, s.perdidaEconomica) from Siniestro as s where s.perdidaEconomica>1000")
    List<Map<String, ?>> get4Sql();

    
}
