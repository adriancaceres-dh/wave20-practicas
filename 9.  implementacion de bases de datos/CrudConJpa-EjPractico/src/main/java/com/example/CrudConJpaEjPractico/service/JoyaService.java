package com.example.CrudConJpaEjPractico.service;

import com.example.CrudConJpaEjPractico.DTO.JoyaDTO;
import com.example.CrudConJpaEjPractico.repository.IJoyaRepository;

import com.example.CrudConJpaEjPractico.entity.Joya;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
@Service
public class JoyaService implements IJoyaService{

    @Autowired
    IJoyaRepository repository;

    ModelMapper mapper = new ModelMapper();

    @Override
    public JoyaDTO create(JoyaDTO joyaDTO) {
        var joyaEntity = mapper.map(joyaDTO, Joya.class);
        joyaEntity = repository.save(joyaEntity);
        return mapper.map(joyaEntity, JoyaDTO.class);
    }

    @Override
    public List<JoyaDTO> getJoyas() {

        var list = repository.findAll();

        return list.stream().map(
                joya -> mapper.map(joya, JoyaDTO.class)
        ).collect(Collectors.toList());
    }
}
