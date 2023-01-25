package com.example.LaPerlaCrud.controller;

import com.example.LaPerlaCrud.dto.JoyaDTO;
import com.example.LaPerlaCrud.dto.MessageDTO;
import com.example.LaPerlaCrud.service.IServiceJoya;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jewerly")
public class JoyaController {
    @Autowired
    IServiceJoya joyaService;

    @PostMapping("/new")
    public ResponseEntity<MessageDTO> createPerson(@RequestBody JoyaDTO joyaDTO){
        return ResponseEntity.ok(joyaService.saveJoya(joyaDTO));
    }

    @GetMapping()
    public ResponseEntity<List<JoyaDTO>> getAllPeople(){
        return ResponseEntity.ok(joyaService.getAllJoyas());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<MessageDTO> deletePersonById(@PathVariable Integer id){
        return ResponseEntity.ok(joyaService.deleteJoya(id));
    }

    @PutMapping("update/{id_modificar}")
    public ResponseEntity<JoyaDTO> createPerson(@PathVariable Integer id_modificar, @RequestBody JoyaDTO joyaDTO){
        return ResponseEntity.ok(joyaService.updateJoya(id_modificar,joyaDTO));
    }

}
