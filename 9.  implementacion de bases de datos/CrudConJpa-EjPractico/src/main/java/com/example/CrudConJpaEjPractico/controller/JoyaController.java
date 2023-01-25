package com.example.CrudConJpaEjPractico.controller;


import com.example.CrudConJpaEjPractico.DTO.JoyaDTO;
import com.example.CrudConJpaEjPractico.service.IJoyaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class JoyaController {

    @Autowired
    IJoyaService joyaservice;

    @PostMapping("/create")
    public ResponseEntity<JoyaDTO> createJoya(@RequestBody JoyaDTO joyaDto){
        return ResponseEntity.ok(joyaservice.create(joyaDto));
    }

    @GetMapping("/getall")
    public ResponseEntity<List<JoyaDTO>> getAllJoyas(){
        return ResponseEntity.ok(joyaservice.getJoyas());
    }

    @GetMapping("/ping")
    public String pong(){
        return "Ping-pong";
    }
}
