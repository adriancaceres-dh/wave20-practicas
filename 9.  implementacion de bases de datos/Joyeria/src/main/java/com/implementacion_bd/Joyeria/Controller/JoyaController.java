package com.implementacion_bd.Joyeria.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.implementacion_bd.Joyeria.DTO.JoyaResponseDTO;
import com.implementacion_bd.Joyeria.DTO.NewJoyaResponseDTO;
import com.implementacion_bd.Joyeria.Entities.Joya;
import com.implementacion_bd.Joyeria.Service.JoyeriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Jewerly")
public class JoyaController {
    @Autowired
    JoyeriaService service;
    @Autowired
    ObjectMapper mapper;

    @PostMapping("/new")
    public ResponseEntity<NewJoyaResponseDTO> postJoya(@RequestBody Joya joya){
        NewJoyaResponseDTO newJoya= service.create(joya);

        return ResponseEntity.ok(mapper.convertValue(newJoya, NewJoyaResponseDTO.class));
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<JoyaResponseDTO> getJoyaById(@PathVariable Integer id){
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping()
    public ResponseEntity<List<JoyaResponseDTO>> getAllJoyas(){
        List<JoyaResponseDTO> joyasDTO = service.findAll();
        return ResponseEntity.ok(joyasDTO);
    }

    @DeleteMapping("/id/{id}")
    public void deleteJoya(@PathVariable Integer id){
        service.delete(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<JoyaResponseDTO> updateJoya(@PathVariable Integer id, @RequestBody Joya joya) {
        return ResponseEntity.ok(service.update(id, joya));
    }
}
