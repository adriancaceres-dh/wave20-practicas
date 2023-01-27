package com.example.segurosvehiculos.repository;

import com.example.segurosvehiculos.dtos.response.MarcaModeloResponseDTO;
import com.example.segurosvehiculos.dtos.response.PatenteMarcaModeloResponseDTO;
import com.example.segurosvehiculos.model.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.Year;
import java.util.List;

public interface IVehiculosRepository extends JpaRepository<Vehiculo, Integer> {
  /* Listar la patente y la marca de todos los vehículos ordenados por año de fabricación. */
  List<Vehiculo> findAllByOrderByAnioDesc();

  /* Listar la patente de todos los vehículos que tengan más de cuatro ruedas y hayan sido fabricados en el corriente año. */
  List<Vehiculo> findAllByCantRuedasGreaterThanEqualAndAnioEquals(Integer ruedas, Year anio);

  /* Listar la matrícula, marca y modelo de todos los vehículos que hayan tenido un siniestro con pérdida mayor de 10000 pesos.*/
  @Query("SELECT DISTINCT new com.example.segurosvehiculos.dtos.response.PatenteMarcaModeloResponseDTO(s.vehiculo.patente, s.vehiculo.marca, s.vehiculo.modelo )  " +
          "FROM Siniestro s JOIN s.vehiculo v WHERE s.perdidaTotal > 10000")
  List<PatenteMarcaModeloResponseDTO> findAllBySiniestrosPerdidaTotalGreaterThanEqual(Integer perdida);

  /* Listar la matrícula, marca y modelo de todos los vehículos que hayan tenido un siniestro con pérdida mayor de 10000 pesos y mostrar a cuánto ascendió la pérdida total de todos ellos. */
  @Query("SELECT sum(s.perdidaTotal) FROM Siniestro s JOIN s.vehiculo v WHERE s.perdidaTotal > 10000")
  Integer getPerdidaTotalGreaterOrEqualThan(Integer perdida);

}
