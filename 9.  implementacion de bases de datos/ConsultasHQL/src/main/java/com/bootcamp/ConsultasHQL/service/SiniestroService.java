package com.bootcamp.ConsultasHQL.service;

import com.bootcamp.ConsultasHQL.dto.request.SiniestroRequestDTO;
import com.bootcamp.ConsultasHQL.dto.response.SiniestroResponseDTO;
import com.bootcamp.ConsultasHQL.model.Siniestro;
import com.bootcamp.ConsultasHQL.repository.ISiniestroRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class SiniestroService implements ISiniestroService{
    private final ISiniestroRepository siniestroRepository;
    ModelMapper mapper = new ModelMapper();

    public SiniestroService(ISiniestroRepository siniestroRepository) {
        this.siniestroRepository = siniestroRepository;
    }

    @Override
    public SiniestroResponseDTO create(SiniestroRequestDTO dto) {
        var entity = mapper.map(dto, Siniestro.class);
        siniestroRepository.save(entity);
        return mapper.map(entity, SiniestroResponseDTO.class);
    }
}
