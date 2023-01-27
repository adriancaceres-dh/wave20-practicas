package com.example.segurosvehiculos.service;

import com.example.segurosvehiculos.dtos.response.CrearEntidadResponseDTO;
import com.example.segurosvehiculos.dtos.request.SiniestroRequestDTO;
import com.example.segurosvehiculos.dtos.response.PerdidaTotalDTO;
import com.example.segurosvehiculos.dtos.response.SiniestroResponseDTO;

public interface ISiniestrosService {
  CrearEntidadResponseDTO addNewSiniestro(SiniestroRequestDTO dto);
  SiniestroResponseDTO getSiniestro(Integer id);
  PerdidaTotalDTO getPerdidaTotal(Integer perdida);

}
