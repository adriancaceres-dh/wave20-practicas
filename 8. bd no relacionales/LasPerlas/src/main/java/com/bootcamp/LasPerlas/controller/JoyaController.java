package com.bootcamp.LasPerlas.controller;

import com.bootcamp.LasPerlas.dto.JoyaDTO;
import com.bootcamp.LasPerlas.service.IJoyaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("jewerly")
public class JoyaController {

    @Autowired
    IJoyaService joyaService;

    @PostMapping("/new")
    public ResponseEntity<String> addJewel(@RequestBody JoyaDTO joyaDTO){
        return ResponseEntity.ok(joyaService.saveJewel(joyaDTO));
    }

    @GetMapping("/")
    public ResponseEntity<List<JoyaDTO>> getAllJewels(){
        return ResponseEntity.ok(joyaService.getAllJewels());
    }

    @PutMapping("/update/{id_modificar}")
    public ResponseEntity<JoyaDTO> updateJewel(@RequestBody JoyaDTO joyaDTO, @PathVariable Integer id_modificar) {
        return ResponseEntity.ok(joyaService.updateJewel(joyaDTO, id_modificar));
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<String> removeJewel(@PathVariable Integer id){
        return ResponseEntity.ok(joyaService.deleteJewel(id));
    }

}
