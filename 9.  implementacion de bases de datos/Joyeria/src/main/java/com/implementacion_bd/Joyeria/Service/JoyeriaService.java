package com.implementacion_bd.Joyeria.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.implementacion_bd.Joyeria.DTO.JoyaResponseDTO;
import com.implementacion_bd.Joyeria.DTO.NewJoyaResponseDTO;
import com.implementacion_bd.Joyeria.Entities.Joya;
import com.implementacion_bd.Joyeria.Repository.IJoyeriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JoyeriaService implements ICRUDService<Joya, Integer, NewJoyaResponseDTO, JoyaResponseDTO> {

    @Autowired
    IJoyeriaRepository repository;

    @Autowired
    ObjectMapper mapper;

    @Override
    public List<JoyaResponseDTO> findAll() {

        List<Joya> joyas = repository.findAll().stream().filter(j->j.getVentaONo().equals(true)).collect(Collectors.toList());
        return joyas.stream().map(j->mapper.convertValue(j, JoyaResponseDTO.class)).collect(Collectors.toList());
    }

    @Override
    public JoyaResponseDTO findById(Integer id) {

        Joya joya = repository.findById(id).get();
        return mapper.convertValue(joya, JoyaResponseDTO.class);
    }

    @Override
    public NewJoyaResponseDTO create(Joya requestDto) {
        Joya newJoya = repository.save(requestDto);
        return mapper.convertValue(newJoya, NewJoyaResponseDTO.class);
    }

    @Override
    public JoyaResponseDTO update(Integer id, Joya requestDto) {
        requestDto.setNro_identificatorio(id);
        create(requestDto);
        return mapper.convertValue(requestDto, JoyaResponseDTO.class);
    }

    @Override
    public void delete(Integer id) {
        Joya joya =repository.findById(id).orElseThrow(()->{
            throw new RuntimeException("no se encontro la joya");
        });
        joya.setVentaONo(false);
        create(joya);
    }
}
