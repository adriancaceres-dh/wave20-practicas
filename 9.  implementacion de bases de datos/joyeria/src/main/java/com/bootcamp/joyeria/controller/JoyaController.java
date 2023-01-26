package com.bootcamp.joyeria.controller;

import com.bootcamp.joyeria.dto.JoyaDto;
import com.bootcamp.joyeria.dto.MessageDTO;
import com.bootcamp.joyeria.service.IJoyaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jewerly")
public class JoyaController {
    @Autowired
    IJoyaService joyaService;

    @PostMapping("/new")
    public ResponseEntity<MessageDTO> crearJoya(@RequestBody JoyaDto joyaDto){
        return ResponseEntity.ok(joyaService.createEntity(joyaDto));
    }
    @PutMapping("update/{id_modificar}")
    public ResponseEntity<MessageDTO> editarJoya(@RequestBody JoyaDto joyaDto){
        return ResponseEntity.ok(joyaService.updateEntity(joyaDto));
    }
    @GetMapping("/")
    public ResponseEntity<List<JoyaDto>> allJoyas(){
        return ResponseEntity.ok(joyaService.getAllEntities());
    }

}
