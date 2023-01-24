package com.bootcamp.las_perlas.controller;

import com.bootcamp.las_perlas.dto.JoyaConIdDTO;
import com.bootcamp.las_perlas.dto.JoyaDTO;
import com.bootcamp.las_perlas.service.IJoyaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jewelry")
public class JoyaController {

    IJoyaService joyaService;

    public JoyaController(IJoyaService joyaService) {
        this.joyaService = joyaService;
    }

    @PostMapping("/new")
    public JoyaConIdDTO crearJoya(@RequestBody JoyaDTO joyaDTO) {
        return joyaService.crear(joyaDTO);
    }

    @GetMapping("/")
    public List<JoyaConIdDTO> listarJoyas() {
        return joyaService.listarEnVenta();
    }

    @DeleteMapping("/delete/{id}")
    public JoyaConIdDTO darDeBaja(@PathVariable Long id) {
        return joyaService.darDeBaja(id);
    }

    @PutMapping("/update/{id}")
    public JoyaConIdDTO modificar(@PathVariable Long id, @RequestBody JoyaDTO joyaDTO) {
        return joyaService.actualizar(id, joyaDTO);
    }
}
