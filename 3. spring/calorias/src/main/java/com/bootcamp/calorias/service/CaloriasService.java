package com.bootcamp.calorias.service;

import com.bootcamp.calorias.dto.IngredienteDTO;
import com.bootcamp.calorias.dto.request.RequestPlatoDTO;
import com.bootcamp.calorias.dto.response.ResponsePlatoDTO;
import com.bootcamp.calorias.model.Ingrediente;
import com.bootcamp.calorias.repository.CaloriasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CaloriasService {

    @Autowired
    private CaloriasRepository caloriasRepository;

    public ResponsePlatoDTO procesarPlato (RequestPlatoDTO plato){
        List<Ingrediente> ingredientes = plato.getIngredientes().stream().map(i ->  caloriasRepository.getIngredienteByName(i)).collect(Collectors.toList());
        int totalCalorias = ingredientes.stream().mapToInt(Ingrediente::getCalorias).sum();
        int totalCaloriasDelPlato = totalCalorias*plato.getPesoEnGramos();
        List<IngredienteDTO> ingredienteDTOS = ingredientes.stream().map(i -> new IngredienteDTO(i.getNombre(),i.getCalorias())).collect(Collectors.toList());
        IngredienteDTO ingredienteConMasCalorias = ingredienteDTOS.stream().max(Comparator.comparingInt(IngredienteDTO::getCalorias)).get();
        ResponsePlatoDTO responsePlatoDTO = new ResponsePlatoDTO(plato.getNombre(),plato.getPesoEnGramos(),totalCaloriasDelPlato,ingredienteDTOS,ingredienteConMasCalorias);
        return responsePlatoDTO;
    }

}
