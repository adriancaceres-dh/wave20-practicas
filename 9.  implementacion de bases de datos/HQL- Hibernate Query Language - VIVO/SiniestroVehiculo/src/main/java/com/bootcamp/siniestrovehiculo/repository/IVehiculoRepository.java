package com.bootcamp.siniestrovehiculo.repository;

import com.bootcamp.siniestrovehiculo.entity.Vehiculo;
import com.bootcamp.siniestrovehiculo.entity.templates.VehiculoSiniestroExtendidoTemplate;
import com.bootcamp.siniestrovehiculo.entity.templates.VehiculoSiniestroTemplate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IVehiculoRepository extends JpaRepository<Vehiculo, Long> {

    // Listar las patentes de todos los vehículos registrados.
    @Query("select v.patente from Vehiculo v")
    List<String> getPatentesVehiculo();

    // Listar la patente y la marca de todos los vehículos ordenados por año de fabricación.
    @Query("SELECT new com.bootcamp.siniestrovehiculo.entity.templates.VehiculoSiniestroTemplate" +
            "(s.id, s.vehiculo.patente, s.vehiculo.marca, s.vehiculo.modelo) FROM Siniestro s order by s.vehiculo.annoFabricacion")
    List<VehiculoSiniestroTemplate> getVehiculosSiniestroOrderByFabricacion();

    // Listar la patente de todos los vehículos que tengan más de cuatro ruedas y hayan sido fabricados en el corriente año.
    @Query("select v.patente from Vehiculo v where v.cantRuedas > 4 and v.annoFabricacion = year (current date )")
    List<String> getPatentesVehiculoCon4RuedasActual();

    // Listar la matrícula, marca y modelo de todos los vehículos que hayan tenido un siniestro con pérdida mayor de 10000 pesos.
    @Query("SELECT new com.bootcamp.siniestrovehiculo.entity.templates.VehiculoSiniestroTemplate" +
            "(s.id, s.vehiculo.patente, s.vehiculo.marca, s.vehiculo.modelo) FROM Siniestro s where s.perdidaEconomica > 10000")
    List<VehiculoSiniestroTemplate> getVehiculosSiniestroConPerdidas10000();

    // Listar la matrícula, marca y modelo de todos los vehículos que hayan tenido un siniestro con pérdida mayor de 10000 pesos
    // y mostrar a cuánto ascendió la pérdida total de todos ellos.
    @Query("SELECT new com.bootcamp.siniestrovehiculo.entity.templates.VehiculoSiniestroExtendidoTemplate" +
            "(s.vehiculo.patente, s.vehiculo.marca, s.vehiculo.modelo, SUM (s.perdidaEconomica)) " +
            "FROM Siniestro s where s.perdidaEconomica > 10000 group by s.vehiculo.patente, s.vehiculo.marca, s.vehiculo.modelo")
    List<VehiculoSiniestroExtendidoTemplate> getVehiculosSiniestroTotalPerdidas();
}
