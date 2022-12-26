package com.bootcamp.calorias.controller;

import com.bootcamp.calorias.dto.PlatoDto;
import com.bootcamp.calorias.service.PlatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlatoController {
    @Autowired
    private PlatoService platoService;

    @GetMapping("{plato}/{peso}")
    public PlatoDto getPlato(@PathVariable String plato, @PathVariable double peso) {
        return platoService.getPlato(plato, peso);
    }

}
