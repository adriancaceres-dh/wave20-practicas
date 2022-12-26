package com.bootcamp.calculadora_calorias.service;

import com.bootcamp.calculadora_calorias.dto.IngredienteDTO;
import com.bootcamp.calculadora_calorias.dto.PlatoDTO;
import com.bootcamp.calculadora_calorias.model.Ingrediente;
import com.bootcamp.calculadora_calorias.model.Plato;
import com.bootcamp.calculadora_calorias.repository.IPlatoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PlatoServiceImpl implements IPlatoService {
    @Autowired
    private IPlatoRepository platoRepository;

    ModelMapper mapper = new ModelMapper();

    @Override
    public Optional<PlatoDTO> obtenerInformacionPlato(String nombre) {
        Optional<Plato> platoOptional = platoRepository.obtenerPlato(nombre);

        if(platoOptional.isEmpty())
            return Optional.empty();

        Plato plato =platoOptional.get();
        PlatoDTO platoDTO = new PlatoDTO();

        // Suma de calorías
        platoDTO.setCalorias(plato.getIngredientes().stream().mapToInt(Ingrediente::getCalorias).sum());
        // Ingredientes mapeados a IngredienteDTO
        platoDTO.setIngredientes(
                plato.getIngredientes().stream().map(ingrediente -> mapper.map(ingrediente, IngredienteDTO.class))
                .collect(Collectors.toList())
        );
        // Ingrediente con más calorías
        platoDTO.setIngredienteMasCalorias(
                plato.getIngredientes().stream().max(Comparator.comparingInt(Ingrediente::getCalorias))
                .map(Ingrediente::getNombre).orElse("N/A")
        );

        return Optional.of(platoDTO);
    }

    @Override
    public List<Optional<PlatoDTO>> obtenerInformacionPlatos(List<String> nombres) {
        return nombres.stream()
                .map(this::obtenerInformacionPlato).collect(Collectors.toList());
    }
}
