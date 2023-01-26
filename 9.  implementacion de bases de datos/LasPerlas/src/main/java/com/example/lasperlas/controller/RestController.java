package com.example.lasperlas.controller;

import com.example.lasperlas.dto.ActionResponseDTO;
import com.example.lasperlas.dto.JoyaRequestDTO;
import com.example.lasperlas.dto.JoyaResponseDTO;
import com.example.lasperlas.service.IJoyeriaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/jewelry")
public class RestController {

  private final IJoyeriaService joyeriaService;

  public RestController(IJoyeriaService joyeriaService) {
    this.joyeriaService = joyeriaService;
  }

  @PostMapping("/new")
  public ResponseEntity<ActionResponseDTO> newJewelry(@RequestBody JoyaRequestDTO dto) {
    return new ResponseEntity<>(joyeriaService.newJewelry(dto), HttpStatus.CREATED);
  }

  @GetMapping
  public ResponseEntity<List<JoyaResponseDTO>> getAllJewelry() {
    return new ResponseEntity<>(joyeriaService.getAllJewelry(), HttpStatus.OK);
  }

  @PostMapping("/delete/{id}")
  public ResponseEntity<ActionResponseDTO> deleteJewelry(@PathVariable Integer id) {
    return new ResponseEntity<>(joyeriaService.deleteJewelry(id), HttpStatus.OK);
  }

  @PostMapping("/update/{id}")
  public ResponseEntity<ActionResponseDTO> updateJewelry(@PathVariable Integer id, @RequestBody JoyaRequestDTO dto) {
    return new ResponseEntity<>(joyeriaService.updateJewelry(id, dto), HttpStatus.OK);
  }
}
