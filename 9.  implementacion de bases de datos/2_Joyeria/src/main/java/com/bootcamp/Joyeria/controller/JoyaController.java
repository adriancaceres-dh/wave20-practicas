package com.bootcamp.Joyeria.controller;

import com.bootcamp.Joyeria.dto.request.JoyaRequestDTO;
import com.bootcamp.Joyeria.dto.response.JoyaResponseDTO;
import com.bootcamp.Joyeria.service.IJoyaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jewelry")
public class JoyaController {
    @Autowired
    IJoyaService iJoyaService;

    @PostMapping("/new")
    public ResponseEntity<String> createJoya(@RequestBody JoyaRequestDTO joyaRequestDTO){
        return new ResponseEntity<>("Se guardo joya con nro identificatorio: "+ iJoyaService.createJoya(joyaRequestDTO), HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity<List<JoyaResponseDTO>> listAll(){
        return new ResponseEntity<>(iJoyaService.findAll(),HttpStatus.OK);
    }

    @PutMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable Long id){
        return new ResponseEntity<>(iJoyaService.deleteById(id),HttpStatus.OK);
    }

    @PutMapping("/update/{id_modificar}")
    public ResponseEntity<JoyaResponseDTO> updateById(@PathVariable Long id_modificar,
                                                        @RequestBody JoyaRequestDTO joyaRequestDTO){
        return new ResponseEntity<>(iJoyaService.updateJoya(id_modificar,joyaRequestDTO),HttpStatus.OK);
    }
}
