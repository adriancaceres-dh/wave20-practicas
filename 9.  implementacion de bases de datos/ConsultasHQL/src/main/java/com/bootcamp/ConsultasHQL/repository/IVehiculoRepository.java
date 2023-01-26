package com.bootcamp.ConsultasHQL.repository;

import com.bootcamp.ConsultasHQL.model.Vehiculo;
import com.bootcamp.ConsultasHQL.model.template.PatenteMarcaDeVehiculoTemplate;
import com.bootcamp.ConsultasHQL.model.template.PatenteMarcaModeloDeVehiculoTemplate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
public interface IVehiculoRepository extends JpaRepository<Vehiculo, Long> {
    @Query("SELECT v.patente FROM Vehiculo v")
    List<String> findAllPatentes();
    @Query("SELECT new com.bootcamp.ConsultasHQL.model.template.PatenteMarcaDeVehiculoTemplate(v.patente, v.marca) FROM Vehiculo v ORDER BY v.anoDeFabricacion")
    List<PatenteMarcaDeVehiculoTemplate> findPatenteMarcaOrderByAnoFabricacion();
    @Query("SELECT v.patente FROM Vehiculo v WHERE v.cantidadDeRuedas = :ruedas AND v.anoDeFabricacion = YEAR(CURRENT_DATE)")
    List<String> findPatentesByRuedasYAno(Integer ruedas);
    @Query("SELECT DISTINCT new com.bootcamp.ConsultasHQL.model.template.PatenteMarcaModeloDeVehiculoTemplate(v.patente, v.marca, v.modelo) FROM Vehiculo v JOIN v.siniestros as s WHERE s.perdidaEconomica > 10000.0")
    List<PatenteMarcaModeloDeVehiculoTemplate> findPatenteMarcaModeloBySiniestro();

}
