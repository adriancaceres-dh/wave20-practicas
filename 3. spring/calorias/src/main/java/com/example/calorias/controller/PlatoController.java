package com.example.calorias.controller;

import com.example.calorias.dto.PlatoDto;
import com.example.calorias.dto.PlatoNombrePesoDto;
import com.example.calorias.service.PlatoServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
public class PlatoController {

    private final PlatoServiceInterface platoService;

    @Autowired
    public PlatoController(PlatoServiceInterface platoService) {
        this.platoService = platoService;
    }

    @GetMapping("/platos")
    public ResponseEntity<PlatoDto> getPlato(
            @RequestParam String nombre,
            @RequestParam int peso
    ) {
        PlatoDto platoDto = platoService.getPlatoByNameAndWeight(nombre, peso);

        if (platoDto == null ) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok()
                .body(platoDto);
    }

    @PostMapping("/platos")
    public ResponseEntity<List<PlatoDto>> getPlatosFromList(
            @RequestBody List<PlatoNombrePesoDto> nombresPlatos
    ) {
        List<PlatoDto> platos = platoService.getPlatosByNamesAndWeights(nombresPlatos);

        boolean anyNullPlato = platos.stream().anyMatch(Objects::isNull);
        if (anyNullPlato) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(platos);
    }
}
