package com.deportistas.deportistas.services;

import java.util.ArrayList;
import java.util.List;

import javax.management.AttributeNotFoundException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.deportistas.deportistas.dto.response.BuscaDeporteResponseDto;
import com.deportistas.deportistas.dto.response.ListaDeportesResponseDto;
import com.deportistas.deportistas.models.Deportista;
import com.deportistas.deportistas.repository.DeportesRepository;

@Service
public class DeporteService {
    @Autowired
    private DeportesRepository deportesRepository;

    @Autowired
    private ModelMapper mapper;

    public List<ListaDeportesResponseDto> listarDeportes() {
        List<Deportista> deportistas = deportesRepository.listarDeportes();
        List<ListaDeportesResponseDto> deportesDto = new ArrayList<>();
        deportistas.stream().forEach(d -> deportesDto.add(mapper.map(d, ListaDeportesResponseDto.class)));

        return deportesDto;

    }

    public BuscaDeporteResponseDto buscarDeporte(String queDeporte)  {
        Deportista deporte = deportesRepository.buscaDeporte(queDeporte);
        return mapper.map(deporte, BuscaDeporteResponseDto.class);
    }
}
