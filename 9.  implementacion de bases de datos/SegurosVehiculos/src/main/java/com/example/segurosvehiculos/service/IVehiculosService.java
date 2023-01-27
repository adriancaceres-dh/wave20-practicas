package com.example.segurosvehiculos.service;

import com.example.segurosvehiculos.dtos.response.CrearEntidadResponseDTO;
import com.example.segurosvehiculos.dtos.request.VehiculoRequestDTO;
import com.example.segurosvehiculos.dtos.response.MarcaModeloResponseDTO;
import com.example.segurosvehiculos.dtos.response.PatenteMarcaModeloResponseDTO;
import com.example.segurosvehiculos.dtos.response.VehiculoResponseDTO;

import java.time.Year;
import java.util.List;

public interface IVehiculosService {
  CrearEntidadResponseDTO addNewVehicle(VehiculoRequestDTO dto);
  VehiculoResponseDTO getVehicle(Integer id);
  List<MarcaModeloResponseDTO> getAllVehiclesOrderByYear();
  List<PatenteMarcaModeloResponseDTO> findAllBySiniestrosPerdidaTotalGreaterThanEqual(Integer perdida);
  List<String> findAllByCantRuedasGreaterThanEqualAndAnioEquals(Integer cantRuedas, Year anio);
}
