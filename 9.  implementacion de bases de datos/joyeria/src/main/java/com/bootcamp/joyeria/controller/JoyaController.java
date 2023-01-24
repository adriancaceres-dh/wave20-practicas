package com.bootcamp.joyeria.controller;

import com.bootcamp.joyeria.dto.request.JoyaRequestDTO;
import com.bootcamp.joyeria.dto.response.JoyaResponseDTO;
import com.bootcamp.joyeria.service.IJoyaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jewerly")
public class JoyaController {
    private final IJoyaService joyaService;

    public JoyaController(IJoyaService joyaService) {
        this.joyaService = joyaService;
    }

    @PostMapping("/new")
    public ResponseEntity<JoyaResponseDTO> saveJoya(@RequestBody JoyaRequestDTO dto){
        return new ResponseEntity<>(joyaService.save(dto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<JoyaResponseDTO> getJoya(@PathVariable Long id){
        return new ResponseEntity<>(joyaService.findById(id), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<JoyaResponseDTO>> getAllJoyas(){
        return new ResponseEntity<>(joyaService.findAll(), HttpStatus.OK);
    }

    @PutMapping("/delete/{id}")
    public ResponseEntity<String> deleteJoya(@PathVariable Long id){
        return new ResponseEntity<>(joyaService.delete(id), HttpStatus.OK);
    }

    @PutMapping("/update/{id_modificar}")
    public ResponseEntity<String> updateJoya(@PathVariable Long id_modificar, @RequestBody JoyaRequestDTO dto){
        return new ResponseEntity<>(joyaService.update(id_modificar, dto), HttpStatus.OK);
    }


}
