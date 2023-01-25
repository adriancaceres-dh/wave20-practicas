package com.example.MapeoClaveCompuesta.controller;

import com.example.MapeoClaveCompuesta.dto.CompraRequestDTO;
import com.example.MapeoClaveCompuesta.dto.CompraResponseDTO;
import com.example.MapeoClaveCompuesta.service.ICompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CompraController {

    @Autowired
    ICompraService iCompraService;

    @PostMapping("")
    public ResponseEntity<CompraResponseDTO> createCompra(@RequestBody CompraRequestDTO compraRequestDTO){
        return ResponseEntity.ok(iCompraService.createCompra(compraRequestDTO));
    }
}
