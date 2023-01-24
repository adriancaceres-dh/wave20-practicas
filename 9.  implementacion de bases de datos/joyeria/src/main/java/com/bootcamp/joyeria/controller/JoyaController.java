package com.bootcamp.joyeria.controller;

import com.bootcamp.joyeria.dtos.ActualizaJoyaDto;
import com.bootcamp.joyeria.dtos.JoyaRequestDto;
import com.bootcamp.joyeria.dtos.JoyaResponseDto;
import com.bootcamp.joyeria.dtos.MensajeDto;
import com.bootcamp.joyeria.service.IJoyaService;
import com.bootcamp.joyeria.service.JoyaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jewerly")
public class JoyaController {

    private final IJoyaService joyaService;

    public JoyaController(JoyaService joyaService) { this.joyaService = joyaService; }

    @PostMapping("/new")
    public ResponseEntity<MensajeDto> crearJoya(@RequestBody JoyaRequestDto joyaDto) {
        return ResponseEntity.ok(joyaService.crearJoya(joyaDto));
    }

    @GetMapping("")
    public ResponseEntity<List<JoyaResponseDto>> listarJoyas() {
        return ResponseEntity.ok(joyaService.obtenerJoyas());
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<MensajeDto> eliminarJoya(@PathVariable Long id) {
        return ResponseEntity.ok(joyaService.eliminarJoya(id));
    }

    @PostMapping("/update/{id_modificar}")
    public ResponseEntity<ActualizaJoyaDto> actualizarJoya(@PathVariable Long id_modificar, @RequestBody JoyaRequestDto joyaDto) {
        return ResponseEntity.ok(joyaService.actualizarJoya(id_modificar, joyaDto));
    }
}
