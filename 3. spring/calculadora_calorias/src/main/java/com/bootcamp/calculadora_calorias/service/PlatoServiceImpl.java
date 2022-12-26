package com.bootcamp.calculadora_calorias.service;

import com.bootcamp.calculadora_calorias.dto.IngredienteDTO;
import com.bootcamp.calculadora_calorias.dto.PlatoDTO;
import com.bootcamp.calculadora_calorias.model.Ingrediente;
import com.bootcamp.calculadora_calorias.model.Plato;
import com.bootcamp.calculadora_calorias.repository.IPlatoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.stream.Collectors;

@Service
public class PlatoServiceImpl implements IPlatoService {
    @Autowired
    private IPlatoRepository platoRepository;

    ModelMapper mapper = new ModelMapper();

    @Override
    public PlatoDTO obtenerInformacionPlato(String nombre) {
        Plato plato = platoRepository.obtenerPlato(nombre).get();
        PlatoDTO platoDTO = new PlatoDTO();

        platoDTO.setCalorias(plato.getIngredientes().stream().mapToInt(Ingrediente::getCalorias).sum());
        platoDTO.setIngredientes(
                plato.getIngredientes().stream().map(ingrediente -> mapper.map(ingrediente, IngredienteDTO.class))
                .collect(Collectors.toList())
        );
        platoDTO.setIngredienteMasCalorias(
                plato.getIngredientes().stream().max(Comparator.comparingInt(Ingrediente::getCalorias))
                .map(Ingrediente::getNombre).get()
        );

        return platoDTO;
    }
}
