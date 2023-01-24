package com.example.Joyeria_Las_Perlas.controllers;

import com.example.Joyeria_Las_Perlas.DTO.AllJoyasResponseDto;
import com.example.Joyeria_Las_Perlas.DTO.JoyaCreatedDto;
import com.example.Joyeria_Las_Perlas.DTO.JoyaDto;
import com.example.Joyeria_Las_Perlas.services.IJoyeriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/jewerly")
public class JoyeriaController {

    @Autowired
    IJoyeriaService joyeriaService;

    @PostMapping(path = "/new")
    public ResponseEntity<JoyaCreatedDto> createJoya(@RequestBody JoyaDto newJoya){
            return new ResponseEntity<>(joyeriaService.saveJoya(newJoya), HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<AllJoyasResponseDto> sendLastPostOfFollowed() {
        return new ResponseEntity<AllJoyasResponseDto>(joyeriaService.getJoyas(),HttpStatus.ACCEPTED);
    }
}
