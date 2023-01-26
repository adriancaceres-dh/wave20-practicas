package com.bootcamp.ConsultasHQL.service;

import com.bootcamp.ConsultasHQL.dto.request.SiniestroRequestDTO;
import com.bootcamp.ConsultasHQL.dto.request.VehiculoResquestDTO;
import com.bootcamp.ConsultasHQL.dto.response.SiniestroResponseDTO;
import com.bootcamp.ConsultasHQL.dto.response.VehiculoResponseDTO;

public interface ISiniestroService {
    SiniestroResponseDTO create (SiniestroRequestDTO dto);
}
