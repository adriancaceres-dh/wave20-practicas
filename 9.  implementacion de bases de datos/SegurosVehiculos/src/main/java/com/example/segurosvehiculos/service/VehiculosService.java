package com.example.segurosvehiculos.service;

import com.example.segurosvehiculos.dtos.response.*;
import com.example.segurosvehiculos.dtos.request.VehiculoRequestDTO;
import com.example.segurosvehiculos.model.Vehiculo;
import com.example.segurosvehiculos.repository.IVehiculosRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.Year;
import java.util.List;
import java.util.Optional;

@Service
public class VehiculosService implements IVehiculosService {
  private final IVehiculosRepository vehiculosRepository;

  private final ModelMapper modelMapper = new ModelMapper();
  public VehiculosService(IVehiculosRepository vehiculosRepository) {
    this.vehiculosRepository = vehiculosRepository;
  }

  @Override
  public CrearEntidadResponseDTO addNewVehicle(VehiculoRequestDTO dto) {
    Integer id = vehiculosRepository.save(modelMapper.map(dto, Vehiculo.class)).getId();
    return CrearEntidadResponseDTO.builder()
            .id(id)
            .message("Vehiculo creado con exito")
            .build();
  }

  @Override
  public VehiculoResponseDTO getVehicle(Integer id) {
    Optional<Vehiculo> opt = vehiculosRepository.findById(id);
    if (opt.isPresent()) {
      return modelMapper.map(opt.get(), VehiculoResponseDTO.class);
    }
    else throw new RuntimeException("Vehiculo no encontrado");
  }

  @Override
  public List<MarcaModeloResponseDTO> getAllVehiclesOrderByYear() {
    return vehiculosRepository.findAllByOrderByAnioDesc().stream()
            .map(v -> modelMapper.map(v, MarcaModeloResponseDTO.class)).toList();
  }

  @Override
  public List<PatenteMarcaModeloResponseDTO> findAllBySiniestrosPerdidaTotalGreaterThanEqual(Integer perdida) {
    return vehiculosRepository.findAllBySiniestrosPerdidaTotalGreaterThanEqual(perdida);
  }

  @Override
  public List<String> findAllByCantRuedasGreaterThanEqualAndAnioEquals(Integer cantRuedas, Year anio) {
    List<String> result = vehiculosRepository.findAllByCantRuedasGreaterThanEqualAndAnioEquals(cantRuedas, anio).stream()
            .map(Vehiculo::getPatente).toList();
    return result;
  }

}
