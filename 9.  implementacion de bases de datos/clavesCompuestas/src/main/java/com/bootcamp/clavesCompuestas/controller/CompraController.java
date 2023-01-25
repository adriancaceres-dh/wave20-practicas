package com.bootcamp.clavesCompuestas.controller;

import com.bootcamp.clavesCompuestas.dto.CompraDTO;
import com.bootcamp.clavesCompuestas.model.Compra;
import com.bootcamp.clavesCompuestas.repository.CompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class CompraController {

    @Autowired
    CompraRepository compraRepository;

    @PostMapping("/create")
    public ResponseEntity<?> create(CompraDTO compraDTO){
        Compra compra = Compra.builder()
                .fecha(LocalDate.now())
                .producto(compraDTO.getProducto())
                .build();
        compraRepository.save(compra);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
