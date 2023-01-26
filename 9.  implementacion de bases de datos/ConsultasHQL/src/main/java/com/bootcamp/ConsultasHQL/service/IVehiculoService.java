package com.bootcamp.ConsultasHQL.service;

import com.bootcamp.ConsultasHQL.dto.request.VehiculoResquestDTO;
import com.bootcamp.ConsultasHQL.dto.response.VehiculoResponseDTO;
import com.bootcamp.ConsultasHQL.model.template.PatenteMarcaDeVehiculoTemplate;
import com.bootcamp.ConsultasHQL.model.template.PatenteMarcaModeloDeVehiculoTemplate;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IVehiculoService {
    VehiculoResponseDTO create (VehiculoResquestDTO dto);
    List<String> findAllPatentes();
    List<PatenteMarcaDeVehiculoTemplate> findPatenteMarcaOrderByAnoFabricacion();
    List<String> findPatentesByRuedasYAno(Integer ruedas);
    List<PatenteMarcaModeloDeVehiculoTemplate> findPatenteMarcaModeloBySiniestro();
}
