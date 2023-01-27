package com.example.segurosvehiculos.service;

import com.example.segurosvehiculos.dtos.response.CrearEntidadResponseDTO;
import com.example.segurosvehiculos.dtos.request.SiniestroRequestDTO;
import com.example.segurosvehiculos.dtos.response.PatenteMarcaModeloResponseDTO;
import com.example.segurosvehiculos.dtos.response.PerdidaTotalDTO;
import com.example.segurosvehiculos.dtos.response.SiniestroResponseDTO;
import com.example.segurosvehiculos.model.Siniestro;
import com.example.segurosvehiculos.repository.ISiniestrosRepository;
import com.example.segurosvehiculos.repository.IVehiculosRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class SiniestrosService implements ISiniestrosService {

  private final ModelMapper modelMapper = new ModelMapper();
  private final ISiniestrosRepository siniestrosRepository;
  private final IVehiculosRepository vehiculosRepository;

  public SiniestrosService(ISiniestrosRepository siniestrosRepository, IVehiculosRepository vehiculosRepository) {
    this.siniestrosRepository = siniestrosRepository;
    this.vehiculosRepository = vehiculosRepository;
  }

  @Override
  public CrearEntidadResponseDTO addNewSiniestro(SiniestroRequestDTO dto) {
    Siniestro siniestro = siniestrosRepository.save(modelMapper.map(dto, Siniestro.class));

    return CrearEntidadResponseDTO.builder()
            .id(siniestro.getId())
            .message("Siniestro creado con exito")
            .build();
  }

  @Override
  public SiniestroResponseDTO getSiniestro(Integer id) {
    return modelMapper.map(siniestrosRepository.findById(id).orElseThrow(() -> new RuntimeException("Siniestro no encontrado")), SiniestroResponseDTO.class);
  }

  @Override
  public PerdidaTotalDTO getPerdidaTotal(Integer perdida) {
    return PerdidaTotalDTO.builder()
            .perdidaTotal(vehiculosRepository.getPerdidaTotalGreaterOrEqualThan(perdida))
            .vehiculos(vehiculosRepository.findAllBySiniestrosPerdidaTotalGreaterThanEqual(perdida).stream()
                    .map(v -> modelMapper.map(v, PatenteMarcaModeloResponseDTO.class)).toList())
            .build();
  }

}
