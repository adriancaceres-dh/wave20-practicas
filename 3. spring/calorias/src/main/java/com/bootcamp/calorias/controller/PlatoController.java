package com.bootcamp.calorias.controller;

import com.bootcamp.calorias.dto.IngredienteDto;
import com.bootcamp.calorias.dto.PlatoDto;
import com.bootcamp.calorias.dto.PlatoResponseDto;
import com.bootcamp.calorias.model.Ingrediente;
import com.bootcamp.calorias.service.PlatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PlatoController {
    @Autowired
    private PlatoService platoService;

    @PostMapping("/calculate")
    public PlatoResponseDto getTotalCalories(@RequestBody PlatoDto plato) {
        return platoService.generateResponseForPlato(plato);
    }

    @PostMapping("/calculateAll")
    public List<PlatoResponseDto> getTotalCaloriesForAll(@RequestBody List<PlatoDto> platos) {
        return platoService.generateResponseForPlatos(platos);
    }

    @GetMapping("/ping")
    public PlatoDto platoDto() {
        PlatoDto ejemplo = new PlatoDto();
        IngredienteDto ingredientesEjemplo = new IngredienteDto(new Ingrediente("Tuco", 10), 10);
        IngredienteDto ingredientesEjemplo2 = new IngredienteDto(new Ingrediente("Fideos", 12), 12);
        ejemplo.setName("Fideos con tuco");
        ejemplo.setIngredients(new ArrayList<>(List.of(ingredientesEjemplo, ingredientesEjemplo2)));
        return ejemplo;
    }


}
