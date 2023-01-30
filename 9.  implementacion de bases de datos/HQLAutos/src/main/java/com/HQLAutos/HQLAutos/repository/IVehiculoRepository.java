package com.HQLAutos.HQLAutos.repository;

import com.HQLAutos.HQLAutos.DTO.MarcaYPatenteDTO;
import com.HQLAutos.HQLAutos.DTO.MatriculaMarcaYModeloDTO;
import com.HQLAutos.HQLAutos.model.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IVehiculoRepository extends JpaRepository<Vehiculo,Long> {
    @Query("SELECT v.patente FROM Vehiculo v")
    List<String> getPatente();
    @Query("SELECT new com.HQLAutos.HQLAutos.DTO.MarcaYPatenteDTO(v.patente, v.marca) FROM Vehiculo v ORDER BY v.fechaFabricacion")
    List<MarcaYPatenteDTO> getMarcaYPatente();
    @Query("SELECT v.patente FROM Vehiculo v WHERE v.cantidadRuedas>4 AND YEAR(v.fechaFabricacion) = YEAR(current_date())")
    List<String> getPatentesVehiculos4Ruedas();
    @Query("SELECT new com.HQLAutos.HQLAutos.DTO.MatriculaMarcaYModeloDTO(s.vehiculo.id,s.vehiculo.marca,s.vehiculo.modelo) FROM Siniestro s WHERE s.perdida>10000")
    List<MatriculaMarcaYModeloDTO> getVehiculosPerdidaMayorA10000();


}
