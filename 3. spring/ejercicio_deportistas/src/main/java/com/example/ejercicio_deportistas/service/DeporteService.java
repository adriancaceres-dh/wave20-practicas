package com.example.ejercicio_deportistas.service;

import com.example.ejercicio_deportistas.dto.response.DeporteResponseDto;
import com.example.ejercicio_deportistas.repository.DeporteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.stream.Collectors;

public class DeporteService {
    ModelMapper modelMapper;
    DeporteRepository deporteRepository;

    public DeporteService() {
        deporteRepository = new DeporteRepository();
        modelMapper = new ModelMapper();
    }

    public ResponseEntity<List<DeporteResponseDto>> findAll(){

        List<DeporteResponseDto> deporteResponseDtos = deporteRepository.findAll().stream()
                .map(e -> modelMapper.map(e, DeporteResponseDto.class)).collect(Collectors.toList());

        return new ResponseEntity<>(deporteResponseDtos, HttpStatus.OK);
    }

    public ResponseEntity<DeporteResponseDto> findByName(String name){
        DeporteResponseDto deporteResponseDto = modelMapper.map(deporteRepository.findByName(name), DeporteResponseDto.class);

        return new ResponseEntity<>(deporteResponseDto,HttpStatus.OK);
    }


}
