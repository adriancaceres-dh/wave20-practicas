package com.example.Empresa.Seguros.Practica.HQL.Vivo.repository;

import com.example.Empresa.Seguros.Practica.HQL.Vivo.model.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IVehiculoRepository extends JpaRepository<Vehiculo,Long> {

    List<Vehiculo> findAllByOrderByAnhoFabricacion();
    List<Vehiculo> findAllByCantRuedasGreaterThanAndAnhoFabricacionEquals(Integer cantRuedas, Integer anhoFabricacion);
    @Query("FROM Vehiculo AS v JOIN v.siniestros AS vs "+
            "WHERE vs.perdidaEconomica > :loss")
    List<Vehiculo> findAllExpensiveSiniestro(@Param("loss")Double loss);
    @Query("SELECT SUM(vs.perdidaEconomica) FROM Vehiculo AS v "+
            "JOIN v.siniestros AS vs "+
            "WHERE vs.perdidaEconomica > :loss")
    Double findTotalLossMoreExpensiveThan(@Param("loss") Double loss);

}
