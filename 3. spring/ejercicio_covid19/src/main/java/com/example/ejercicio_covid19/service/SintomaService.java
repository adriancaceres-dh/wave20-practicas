package com.example.ejercicio_covid19.service;

import com.example.ejercicio_covid19.dto.response.SintomaResponseDto;
import com.example.ejercicio_covid19.model.Sintoma;
import com.example.ejercicio_covid19.repository.RepositorySintoma;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.stream.Collectors;

public class SintomaService {

    RepositorySintoma repositorySintoma;
    ModelMapper modelMapper;



    public SintomaService() {
        repositorySintoma = new RepositorySintoma();
        modelMapper = new ModelMapper();
    }

    public List<SintomaResponseDto> findAll(){
        List<SintomaResponseDto> sintomaResponseDtos = repositorySintoma.findAll()
                .stream().map(e -> modelMapper.map(e, SintomaResponseDto.class)).collect(Collectors.toList());

        return sintomaResponseDtos;
    }

    public SintomaResponseDto findByName(String name){
        return modelMapper.map(repositorySintoma.findByName(name), SintomaResponseDto.class);
    }
}
