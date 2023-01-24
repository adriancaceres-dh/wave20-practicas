package com.bootcamp.joyeria.controller;

import com.bootcamp.joyeria.dtos.JoyaRequestDto;
import com.bootcamp.joyeria.dtos.JoyaResponseDto;
import com.bootcamp.joyeria.dtos.MessageDto;
import com.bootcamp.joyeria.service.IJoyaService;
import com.bootcamp.joyeria.service.JoyaService;
import com.bootcamp.joyeria.util.Params;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jewerly")
public class JoyaController {

    private final IJoyaService joyaService;

    public JoyaController(JoyaService joyaService) { this.joyaService = joyaService; }

    @PostMapping("/new")
    public ResponseEntity<MessageDto> crearJoya(@RequestBody JoyaRequestDto joyaDto) {
        return ResponseEntity.ok(joyaService.crearJoya(joyaDto));
    }

    @GetMapping("")
    public ResponseEntity<List<JoyaResponseDto>> listarJoyas() {
        return ResponseEntity.ok(joyaService.obtenerJoyas());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<MessageDto> eliminarJoya(@PathVariable Long id) {
        return ResponseEntity.ok(joyaService.eliminarJoya(id));
    }
}
